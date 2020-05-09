#include "Automobile.h"
#include<iostream>
#include<math.h>
#include<cstring>
#define PI 3.14
#define cmTokm 0.00001
using namespace std;
class Car:public Automobile
{
    double distance,angle,FuelEff,Dist_per_move,D_angle,MaxSpeed;

public:
    Car();
    void IncreaseSpeed();
     void DecreaseSpeed();
    void Moving_With_Time(double); //A function to move for a certain time(optional)
    void Move();
    void TurnLeft();
    void TurnRight();
};
 Car::Car():Automobile("Car")
{
    distance=0;
    fuel=30;
    speed=0;
    angle=5*PI/180; //turn angle
    FuelEff=8; //fuel efficiency
    MaxSpeed=120;

}
class SUV:public Automobile
{
    double distance,angle,FuelEff,Dist_per_move,D_angle,MaxSpeed;

public:
    SUV();
    void IncreaseSpeed();
     void DecreaseSpeed();
    void Moving_With_Time(double);
    void Move();
    void TurnLeft();
    void TurnRight();
};
 SUV::SUV():Automobile("SUV")
{
    distance=0;
    fuel=50;
    speed=0;
    angle=10*PI/180;
    FuelEff=6;
    MaxSpeed=100;
}

class Bus:public AutomobileWithManualXmission
{
    double distance,angle,FuelEff,Dist_per_move,D_angle,MaxSpeed;

public:
    Bus();
    void IncreaseSpeed();
     void DecreaseSpeed();
    void Moving_With_Time(double);
    void Move();
    void TurnLeft();
    void TurnRight();
};
 Bus::Bus():AutomobileWithManualXmission("Bus")
{
    distance=0;
    fuel=80;
    speed=0;
    angle=15*PI/180;
    FuelEff=4;
    MaxSpeed=80;
}

class Truck:public AutomobileWithManualXmission
{
    double distance,angle,FuelEff,Dist_per_move,D_angle,MaxSpeed;

public:
    Truck();
    void IncreaseSpeed();
     void DecreaseSpeed();
    void Moving_With_Time(double);
    void Move();
    void TurnLeft();
    void TurnRight();
};
 Truck::Truck():AutomobileWithManualXmission("Truck")
{
    distance=0;
    fuel=100;
    speed=0;
    angle=25*PI/180;
    FuelEff=2;
    MaxSpeed=60;
}
int main()
{
    double Dx,Dy,Px,Py;
    Truck c; //You can also test Car,SUV,Bus
    c.SetInitialPosition(0,0);
    c.SetInitialDirection(-1,1);
    c.ShiftGearUp();//ignore it in case of Automatic
    c.IncreaseSpeed();
    c.Moving_With_Time(2); //optional function
    c.Move();
    c.TurnLeft();
    c.Move();
    c.GetDirection(Dx,Dy);
    c.GetPosition(Px,Py);
    cout<<"Current Direction: "<<Dx<<"   "<<Dy<<endl<<"Current position: " <<Px<<"   "<<Py<<endl<<"Current Speed: "<<c.GetSpeed()<<endl<<"Current fuel stock: "<<c.GetFuel()<<endl<<c.GetGearPosition();
}
void Car::IncreaseSpeed()
    {
        if(!speed) //These only work at very first time
        {
            D_angle=atan(directionY/directionX); //angle of direction vector
            posX*=cmTokm;
            posY*=cmTokm;
        }
        speed+=10;
        if(speed>MaxSpeed)
            speed=MaxSpeed;
        Dist_per_move=speed*1.0/3600;
    }
     void Car::DecreaseSpeed()
    {
            speed-=10;
            if(speed<0)
                speed=0;
    }
    void Car::Moving_With_Time(double time=1)
    {
        distance=speed*time;
    }
    void Car::Move()
    {
        if(!distance) //set default distance
            distance=Dist_per_move;
        fuel-=distance/FuelEff;
        if(fuel<=0)
        {
            fuel=0;
            cout<<"Empty Fuel Stock,Can't move anymore!"<<endl;
            return ;
        }
        posX+=distance*cos(D_angle);
        posY+=distance*sin(D_angle);
        directionX=distance*cos(D_angle);
        directionY=distance*sin(D_angle);
    }
    void Car::TurnLeft()
    {
         D_angle+=angle;
    }
    void Car::TurnRight()
    {
         D_angle-=angle;
    }
void SUV::IncreaseSpeed()
    {
        if(!speed)
        {
            D_angle=atan(directionY/directionX);
            posX*=cmTokm;
            posY*=cmTokm;
        }
        Dist_per_move=speed*1.0/3600;
        speed+=8;
        if(speed>MaxSpeed)
            speed=MaxSpeed;
    }
     void SUV::DecreaseSpeed()
    {
            speed-=8;
            if(speed<0)
                speed=0;
    }
    void SUV::Moving_With_Time(double time=1)
    {
        distance=speed*time;
    }
    void SUV::Move()
    {
        if(!distance)
            distance=Dist_per_move;
        fuel-=distance/FuelEff;
         if(fuel<=0)
        {
            fuel=0;
            cout<<"Empty Fuel Stock,Can't move anymore!"<<endl;
            return;
        }
        posX+=distance*cos(D_angle);
        posY+=distance*sin(D_angle);
        directionX=distance*cos(D_angle);
        directionY=distance*sin(D_angle);
    }
    void SUV::TurnLeft()
    {
         D_angle+=angle;
    }
    void SUV::TurnRight()
    {
         D_angle-=angle;
    }
void Bus::IncreaseSpeed()
    {
       if(!speed)
        {
            D_angle=atan(directionY/directionX);
            posX*=cmTokm;
            posY*=cmTokm;
        }
        Dist_per_move=speed*1.0/3600;
        switch(gearPosition)
        {
            case 0:  cout<<"Lowest Gear position"<<endl;
                        break;
            case 1:  speed+=6;
                       if(speed>20)
                            speed=20;
                        break;

            case 2:  speed+=6;
                       if(speed>30)
                            speed=30;
                        break;
            case 3:  speed+=6;
                       if(speed>45)
                            speed=45;
                        break;
            case 4:  speed+=6;
                       if(speed>60)
                            speed=60;
                        break;
            case 5:  speed+=6;
                       if(speed>80)
                            speed=80;
                        break;
            default : cout<<"Invalid gear position"<<endl;
        }
    }
     void Bus::DecreaseSpeed()
    {
        switch(gearPosition)
        {
            case 0:  cout<<"Lowest Gear position"<<endl;
                        break;
            case 1:  speed-=6;
                       if(speed<0)
                            speed=0;
                        break;

            case 2:  speed-=6;
                       if(speed<10)
                            speed=10;
                        break;
            case 3:  speed-=6;
                       if(speed<25)
                            speed=25;
                        break;
            case 4:  speed-=6;
                       if(speed<35)
                            speed=35;
                        break;
            case 5:  speed-=6;
                       if(speed<50)
                            speed=50;
                        break;
            default : cout<<"Invalid gear position"<<endl;
        }
    }
    void Bus::Moving_With_Time(double time=1)
    {
        distance=speed*time;
    }
    void Bus::Move()
    {
        if(!distance)
            distance=Dist_per_move;
        fuel-=distance/FuelEff;
         if(fuel<=0)
        {
            fuel=0;
            cout<<"Empty Fuel Stock,Can't move anymore!"<<endl;
            return;
        }
        posX+=distance*cos(D_angle);
        posY+=distance*sin(D_angle);
        directionX=distance*cos(D_angle);
        directionY=distance*sin(D_angle);
    }
    void Bus::TurnLeft()
    {
         D_angle+=angle;
    }
    void Bus::TurnRight()
    {
         D_angle-=angle;
    }
void Truck::IncreaseSpeed()
    {
        if(!speed)
        {
            D_angle=atan(directionY/directionX);
            posX*=cmTokm;
            posY*=cmTokm;
        }
        Dist_per_move=speed*1.0/3600;
        switch(gearPosition)
        {
            case 0:  cout<<"Lowest Gear position"<<endl;
                        break;
            case 1:  speed+=4;
                       if(speed>20)
                            speed=20;
                        break;

            case 2:  speed+=4;
                       if(speed>30)
                            speed=30;
                        break;
            case 3:  speed+=4;
                       if(speed>45)
                            speed=45;
                        break;
            case 4:
            case 5:  speed+=4;
                       if(speed>60)
                            speed=60;
                        break;
            default : cout<<"Invalid gear position"<<endl;
        }
    }
     void Truck::DecreaseSpeed()
    {
        switch(gearPosition)
        {
            case 0:  cout<<"Lowest Gear position"<<endl;
                        break;
            case 1:  speed-=4;
                       if(speed<0)
                            speed=0;
                        break;

            case 2:  speed-=4;
                       if(speed<10)
                            speed=10;
                        break;
            case 3:  speed-=4;
                       if(speed<25)
                            speed=25;
                        break;
            case 4:  speed-=4;
                       if(speed<35)
                            speed=35;
                        break;
            case 5:  speed-=4;
                       if(speed<50)
                            speed=50;
                        break;
            default : cout<<"Invalid gear position"<<endl;
        }
    }
    void Truck::Moving_With_Time(double time=1)
    {
        distance=speed*time;
    }
    void Truck::Move()
    {
        if(!distance)
            distance=Dist_per_move;
        fuel-=distance/FuelEff;
         if(fuel<=0)
        {
            fuel=0;
            cout<<"Empty Fuel Stock,Can't move anymore!"<<endl;
            return;
        }
        posX+=distance*cos(D_angle);
        posY+=distance*sin(D_angle);
        directionX=distance*cos(D_angle);
        directionY=distance*sin(D_angle);
    }
    void Truck::TurnLeft()
    {
         D_angle+=angle;
    }
    void Truck::TurnRight()
    {
         D_angle-=angle;
    }
