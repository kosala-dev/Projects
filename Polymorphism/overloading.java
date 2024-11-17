class overloading{

    public void add(){
        System.out.println("adding 1");
    }
    public void add(int x){
        System.out.println("adding 2");
    }
    public void add(double y){
        System.out.println("adding 3");
    }

    public static void main(String[] args) {
        overloading obj= new overloading();
        obj.add();
        obj.add(5);
        obj.add(4.5);
    }
}