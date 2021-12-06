package test;

/**
 * ArrayList和ListedList集合性能测试对比
 * @author liuchao
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	com.demo.collection.ArrayListTest.addFromHeaderTest(1000);
    	LinkedListTest.addFromHeaderTest(1000);
    	
    	
    	com.demo.collection.ArrayListTest.addFromMidTest(1000);
    	LinkedListTest.addFromMidTest(1000);
    	
    	com.demo.collection.ArrayListTest.addFromTailTest(1000);
    	LinkedListTest.addFromTailTest(1000);
    	
    	com.demo.collection.ArrayListTest.deleteFromHeaderTest(1000);
    	LinkedListTest.deleteFromHeaderTest(1000);
    	
    	com.demo.collection.ArrayListTest.deleteFromMidTest(1000);
    	LinkedListTest.deleteFromMidTest(1000);
    	
    	com.demo.collection.ArrayListTest.deleteFromTailTest(1000);
    	LinkedListTest.deleteFromTailTest(1000);
    	
    	com.demo.collection.ArrayListTest.getByForTest(1000);
    	LinkedListTest.getByForTest(1000);
    	
    	com.demo.collection.ArrayListTest.getByIteratorTest(1000);
    	LinkedListTest.getByIteratorTest(1000);


    }
}