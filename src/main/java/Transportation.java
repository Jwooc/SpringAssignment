import java.util.Scanner;

class publicTransportation {
    final int num;
    static int fuel=100;
    static int speed;
    int speedChange=30;
    int maxPassengerNum=30;
    boolean status =false;
    int passengerNum;
    int restSeat=0;

    public publicTransportation(int num){
        this.num=num;
        this.fuel=fuel;
        this.speed=speed;
        this.speedChange=speedChange;
        this.maxPassengerNum=maxPassengerNum;
        this.status=status;
        this.passengerNum=passengerNum;
    }

    public void onboardPassenger(int passenger){
        if(0 < passenger){
            restSeat += passenger;
        }
        System.out.println("탑승 승객 수 = "+this.restSeat);
    }
    
    void setSpeedChange(int speed){
        this.speed=0;
        
        System.out.println("현재 속도 = "+this.speed);
        System.out.println("변경할 속도 = "+this.speedChange);
        
        this.speed += speedChange;
        System.out.println("변경된 속도 = "+this.speed);
    }
}

class Bus extends publicTransportation {
    int fuel;
    public Bus(int num, int fuel){
        super(num);
        
        this.fuel =fuel;
    }
    
    void alert(int passenger){
        this.passengerNum += passenger;
        if(passenger > 30)
            System.out.println("최대 승객 수 초과");
        else{
            System.out.printf("탑승 승객 수 = %d\n", this.passengerNum);
            System.out.printf("잔여 승객 수 = %d\n", 30-this.passengerNum);
            System.out.printf("요금 = %d\n", this.passengerNum*1000);
        }
    }

    void fuelVolume(boolean status, int fuel){
        Scanner scanner=new Scanner(System.in) ;

        System.out.println("운행을 계속하시겠습니까?");
        System.out.println("1. 네");
        System.out.println("2. 아니요");

        int scan =scanner.nextInt();

        if(scan==1){
            System.out.printf("운행중\n");
            System.out.printf("주유량 = %d\n", this.fuel);
        }
        else if(scan==2){
            this.status=false;
            System.out.println("상태 = 차고지행\n");
            System.out.println("주유량 : "+this.fuel+10);
        }
    }

    void fillUp(int fuel){
        this.fuel += fuel;
        if(50 > fuel)
            System.out.println("가득");
        else if (5 <= fuel)
            System.out.println("주유 필요");
        else
            System.out.println("주유량 = "+this.fuel);
    }
}

class Taxi extends publicTransportation {
    String destinatn;
    int distce =1;
    int price=3000;
    int farePerDistance=1000;
    int gas=100;
    String state="일반";
    int speed=0;
    String destination;
    int fee;

    public Taxi(int num, int gas){
        super(num);

        this.gas=gas;
    }

    void onboardPassnger(int passenger){
        this.passengerNum += passenger;

        if(passenger > 5)
            System.out.println("최대 승객 수 초과");
        else
            System.out.printf("탑승 승객 수 = %d\n", this.passengerNum);
            System.out.printf("잔여 승객 수 = %d\n", 4-this.passengerNum);
            System.out.printf("기본 요금 확인 = %d\n", this.distce*1000);
    }
    
    void onboardPassngr(String destination, int distance){
        this.passengerNum += passengerNum;
        
        System.out.printf("목적지 = %s\n", this.destinatn);
        System.out.printf("목적지까지 거리 = %dkm\n", 4-this.distce, "km%c\n");
        System.out.printf("지불할 요금 = %d\n", this.distce*1000);
        System.out.printf("상태 = %s\n", "운행중");

    }
    
    void fillUp(int gas){
        this.gas += gas;
        this.fee += (distce-1)*1000;

        if(this.gas <= 5){
            System.out.printf("주유량 = %d\n", this.gas);
            System.out.println("상태 = 운행불가");
            System.out.printf("누적 요금 = %d\n", this.fee);
        } else{
            System.out.printf("주유량 = %d\n", this.gas);
            System.out.printf("누적 요금 = %d\n", this.fee);
        }
    }
}


class Main{
    public static void main(String[] args) {
        Bus bus=new Bus(1000,300);
        bus.alert(2);
        Taxi taxi=new Taxi(1000,1000);
        taxi.onboardPassnger(2);
        publicTransportation publicTranspta=new publicTransportation(2);
        publicTranspta.onboardPassenger(1);
        Scanner scanner =new Scanner(System.in);
        bus.fuelVolume(true,2);
        taxi.onboardPassngr("서울역",10);
    }
}