/**
 * ==       比较的是内存地址
 *
 * equals   Object类的默认实现是==；(一般需要根据需求重写比较某个值是否相等)
 *
 * HashCode的设计目的是为了集合操作快速，而根据一定规则而设计的散列码(根据内存地址生成的，为了方便比较和插入数据)，用于HashMap,HashSet,HashTable.
 *
 * hashCode()方法返回的就是一个数值，从方法的名称上就可以看出，其目的是生成一个hash码。hash码的主要用途就是在对对象进行散列的时候作为key输入，
 * 据此很容易推断出，我们需要每个对象的hash码尽可能不同，这样才能保证散列的存取性能。事实上，Object类提供的默认实现确实保证每个对象的hash码不同
 * （在对象的内存地址基础上经过特定算法返回一个hash码）。Java采用了哈希表的原理。哈希（Hash）实际上是个人名，由于他提出一哈希算法的概念，
 * 所以就以他的名字命名了。 哈希算法也称为散列算法，是将数据依特定算法直接指定到一个地址上。
 * 初学者可以这样理解，hashCode方法实际上返回的就是对象存储的物理地址（实际可能并不是）。
 */
 
 /**
  * 请判断，两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，该说法是否正确，为什么？
  *
  * 正确 如果此对象重写了equals方法，那么可能出现这两个对象的equals相同，而hashcode不同。因此可以说它是对的。
  * 但是，如果此对象继承Object，没有重写equals方法，那么就使用Object的equals方法，Object对象的equals方法默认是用==实现的，
  * 那么如果equals相同，hashcode一定相同。
  */