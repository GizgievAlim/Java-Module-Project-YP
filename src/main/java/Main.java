public void main(String[] args) {
    Gonka go = new Gonka();
    go.start();
}



class Gonka{
    Scanner scanner = new Scanner(System.in);
    ArrayList<Auto> spisok = new ArrayList<Auto>();
    public void start(){
        System.out.println("Дорогие гонщики и гонщицы!");
        System.out.println("Добро пожаловать на грандиозную гонку - 24 часа Ле-Мана!");
        System.out.println("Для участия в гонке укажите название и скороть вашего автомобиля");
        System.out.println("Сначала напишите название вашего авто, нажмите ENTER и введите скорсть");
        dataEntry();
        results(spisok);

    }
    private void dataEntry(){//Тут реализовал проверку чтобы не было поломок программы если будут ошибки в вводе
        for(int i = 1;i<=3;i++) {
            boolean valid = false;
            System.out.println("Введите название авто №" + i + ":");
            String name = scanner.nextLine();
            System.out.println("Укажите скорость авто №" + i + ":");
            while(!valid) {
                try {
                    int speed = scanner.nextInt();
                    scanner.nextLine(); //Очистка буфера от мусора чтобы ввод работал коррекно
                    while (true) {
                        if (speed > 0 && speed <= 250) {
                            break;
                        } else {
                            System.out.println("Скорость должна быть больше 0 и не больше 250");
                            System.out.println("Введите скорость заново:");
                            speed = scanner.nextInt();
                        }
                    }
                    spisok.add(new Auto(name, speed));
                    valid = true;

                } catch (Exception e) {
                    System.out.println("Неверно! Используйте только числа!");
                    scanner.next();
                }
            }
        }
    }
    private void results(ArrayList<Auto> a){//Функция проводит все необходимые вычисления и выводит победителя
        int maxDistance = 0; //Переменная показывающая максимальную дистанцию
        String winner= ""; // Переменная хранящая гонщика с максимальной дистанцией
        for(Auto item : a){
            int i = item.speed * 24;
            if (i > maxDistance){
                winner = item.name;
                maxDistance = i;
            }
        }
        System.out.println("Победителем нашей грандиозной гонки стал: "+ winner);
    }
}

public class Auto{
    String name;
    int speed;
    public Auto(String name,int speed){
        this.name = name;
        this.speed = speed;
    }
}