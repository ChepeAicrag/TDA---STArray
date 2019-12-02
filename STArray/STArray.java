
/**
 * TDA ST utilizando array paralelos
 * 
 * @author García García José Ángel
 * @version 30/11/2019
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
public class STArray<Key,Value> implements Iterable<Key>
{
    /**
     * Campos de la clase
       */
    private int tamMax = 0;
    private int n = 0;
    private Key[] keys;
    private Value[] values;
    
    /**
     * Contructor de una ST
     * @param tam Establece el tamaño maximo de la ST 
       */
    public STArray(int tam){
        this.tamMax = tam;
        keys = (Key[]) new Object[tamMax];
        values = (Value[]) new Object[tamMax];
    }  
    
    /**
     * Retorna las keys y values que contiene la tabla 
     * @return Cuantas elementos existe en la Tabla
       */
    public int size(){
        return n;
    }
      
    /**
     * Retorna la capacidad que tiene la tabla
     * @return Cuantos elementos puede guardar la ST
       */
    public int length(){
        return tamMax;
    }
    
    /**
     * Indica si la lista esá vacia o no
     * @return true si la lista está vacia y false de lo contrario
       */
    public boolean isEmpty(){
        return size() == 0;
    }
    
    /**
     * Reajusta la capacidad de la Tabla
     * @param tam El nuevo tamaño de la Tabla 
       */
    public void resize(int tam){
        if(tam <= tamMax)
            return;
        tamMax = tam;
        Key[] tempk = (Key[]) new Object[tam];
        Value[] tempv = (Value[]) new Object[tam];
        for(int i = 0; i < n; i++){
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        keys = tempk;
        values = tempv;
    } 
    
    /**
     * Comprueba si la Tabla contiene a la Key
     * @param key La key que se busca 
     * @return true si la key se encuentra y false de lo contrario
       */
    public boolean contains(Key key){
        for(int i = 0; i < n; i++)
            if(key.equals(keys[i]))
                return true;
        return false;
    }
    
    /**
     * Conocer que contiene una llave
     * @param key Key de la que queremos saber su valor
     * @return el valor contenido en la key, null si no encuentra la key
       */
    public Value get(Key key){
        for(int i = 0; i < n; i++)
            if(key.equals(keys[i]))
                return values[i];
        return null;        
    }
    
    /**
     * Elimina a una key, moviendo a la ultima key en lugar de esa
     * @param key La key que se eliminara de la tabla
       */
    public void delete(Key key){
        for(int i = 0; i < n; i++){
            if(keys[i].equals(key)){
                keys[i] = keys[n-1];
                values[i] = values[n-1];
                keys[n-1] = null;
                values[n-1] = null;
                n--;
                return;
            }
        }
    }
      
    /**
     * Inserta una key con su value a la tabla
     * @param key La key relacionada al val
     * @param val El val relacionado a la key
       */
    public void put(Key key, Value val){
        delete(key);
        if (n >= values.length) 
            resize(2*n);
        keys[n] = key;
        values[n] = val;
        n++;
    }  
    
    /**
     * Imprime lo contenido en la tabla
       */
    public void printf(){
        System.out.println("Contenido de la tabla");
        if(!isEmpty())
        for(Key k : this){
            System.out.println(k + " ---- " + this.get(k));
        }
        else 
            System.out.println("Tabla vacía");
    }
    
    /**
     * Obtener un iterador de la tabla
     * @return Un iterador
       */
    public Iterator<Key> iterator(){
        return new STiterator();
    }
    
    /**
     * Clase para implementar Iterator
       */
    private class STiterator implements Iterator<Key>{
          private Key[] tempKeys = keys;
          private int head = 0;
          public boolean hasNext(){
              return tempKeys[head] != null;
            }
          public Key next(){
              if(!hasNext()){
                  throw new NoSuchElementException();
                }
              Key temp = tempKeys[head];
              head++;
              return temp;
            }  
    }
}
