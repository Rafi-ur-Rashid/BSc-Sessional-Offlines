#include<stdio.h>
#include<conio.h>
void main()
{
    int h,m,q,y;
    printf("enter the year : ");
    scanf("%d",&y);
    printf("\nenter the month(1-12): ");
    scanf("%d",&m);
    printf("\nenter the date : ");
    scanf("%d",&q);
    switch(m)
    {
        case 1: m=13;
                y=y-1;
                break;
        case 2: m=14;
                y=y-1;
                break;
    }
    h=(q+((26*(m+1))/10)+y+(y/4)+6*(y/100)+(y/400))%7;
    printf("\n\n");
    switch(m)
    {
             case 1 :  printf("January");
                       break;
             case 2 :  printf("February");
                       break;
             case 3 :  printf("March");
                       break;
             case 4 :  printf("April");
                       break;
             case 5 :  printf("May");
                       break;
             case 6 :  printf("June");
                       break;
             case 7 :  printf("July");
                       break;
             case 8 :  printf("August");
                       break;
             case 9 :  printf("September");
                       break;
             case 10 : printf("October");
                       break;
             case 11 : printf("November");
                       break;
             case 12 : printf("December");
                       break;
    }
    printf(" %d %d is ",q,y);

    switch(h)
    {
        case 0 : printf("saturday");
                 break;
        case 1 : printf("sunday");
                 break;
        case 2 : printf("monday");
                 break;
        case 3 : printf("tuesday");
                 break;
        case 4 : printf("wednesday");
                 break;
        case 5 : printf("thursday");
                 break;
        case 6 : printf("friday");
                 break;
    }



    getch();
}
