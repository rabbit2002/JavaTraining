package comparingobjects;

/**
 * 一个被用来测试的类
 *
 * @author RABBIT2002
 * @date 2020/12/28
 */
class Animal implements Comparable<Animal> {
    private int id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Animal o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", name='" + name + "'}";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
