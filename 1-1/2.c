#include<stdio.h>
int arrange(int y,int m,int s)
{
    int h,i,j,k;
    switch(m)
    {
        case 1:
                m=13;
                y=y-1;
                break;
        case 2:
            m=14;
            y=y-1;
            break;
    }
    printf("\n\nSat Sun Mon Tue Wed Thu Fri\n\n");
    h=(1+((26*(m+1))/10)+y+(y/4)+6*(y/100)+(y/400))%7;
    if(h==0) //for sat 1
    {
        k=1;
        for(i=1; i<=5; i++)
        {
            for(j=1; j<=7; j++)
            {
                printf("%3d ",k);
                k++;
                if(k>s)
                    break;
            }
            printf("\n");
        }
    }
    if(h==1) //for sun 1
    {
        printf("      1   2   3   4   5   6\n");
        k=7;
        for(i=2; i<=5; i++)
        {
            for(j=1; j<=7; j++)
            {
                printf("%3d ",k);
                k++;
                if(k>s)
                    break;
            }
            printf("\n");
        }
    }
    if(h==2) //for mon 1
    {
        printf("          1   2   3   4   5\n");
        k=6;
        for(i=2; i<=5; i++)
        {
            for(j=1; j<=7; j++)
            {
                printf("%3d ",k);
                k++;
                if(k>s)
                    break;
            }
            printf("\n");
        }
    }
    if(h==3) //for tue 1
    {
        printf("              1   2   3   4\n");
        k=5;
        for(i=2; i<=5; i++)
        {
            for(j=1; j<=7; j++)
            {
                printf("%3d ",k);
                k++;
                if(k>s)
                    break;
            }
            printf("\n");
        }
    }
    if(h==4) //for wed 1
    {
        printf("                  1   2   3\n");
        k=4;
        for(i=2; i<=5; i++)
        {
            for(j=1; j<=7; j++)
            {
                printf("%3d ",k);
                k++;
                if(k>s)
                    break;
            }
            printf("\n");
        }
    }
    if(h==5) //for thu 1
    {
        printf("                      1   2\n");
        k=3;
        for(i=2; i<=6; i++)
        {
            for(j=1; j<=7; j++)
            {
                printf("%3d ",k);
                k++;
                if(k>s)
                    break;
            }
            printf("\n");
        }
    }
    if(h==6)        //for fri 1
    {
        printf("                          1\n");
        k=2;
        for(i=2; i<=6; i++)
        {
            for(j=1; j<=7; j++)
            {
                printf("%3d ",k);
                k++;
                if(k>s)
                    break;
            }
            printf("\n");
        }
    }
}
void main(void)
{
    int r,m,y;
    printf("enter the year : ");
    scanf("%d",&y);
    printf("\nenter the month(1-12): ");
    scanf("%d",&m);
    printf("\nCalender for :\n\n");
    switch(m)
    {
             case 1 :  printf("January %d\n\n",y);
                       break;
             case 2 :  printf("February %d\n\n",y);
                       break;
             case 3 :  printf("March %d\n\n",y);
                       break;
             case 4 :  printf("April %d\n\n",y);
                       break;
             case 5 :  printf("May %d\n\n",y);
                       break;
             case 6 :  printf("June %d\n\n",y);
                       break;
             case 7 :  printf("July %d\n\n",y);
                       break;
             case 8 :  printf("August %d\n\n",y);
                       break;
             case 9 :  printf("September %d\n\n",y);
                       break;
             case 10 : printf("October %d\n\n",y);
                       break;
             case 11 : printf("November %d\n\n",y);
                       break;
             case 12 : printf("December %d\n\n",y);
                       break;
    }
    if(m==1 ||m==3 ||m==5 ||m==7 ||m==8 ||m==10 ||m==12 ) //for the months of 31 days
        arrange(y,m,31);
    if(m==4 || m==6 || m==9|| m==11) //for the months of 30 days
         arrange(y,m,30);
    if(m==2)//for the month of February
    {
        r=(y%4==0 && y%100!=0)? 1 :(y%400== 0? 1:0); //leap year test
        if(r)
           arrange(y,m,29);
        if(!r)
             arrange(y,m,28);
    }
}
