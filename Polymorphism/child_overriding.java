class child_overriding extends parent_overriding{
    public void phone(){
        System.out.println("Nokia");
    }
    public void phone(String x){
        System.out.println("Redmi");
    }
    public static void main(String[] args) {
        child_overriding obj = new child_overriding();
        obj.phone();
        obj.phone("Redmi");
    }
}