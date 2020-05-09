#include<stdio.h>
void main()
{
    int m,n,i,j,max,c,d;
    printf("enter the number of elements in the array : ");
    scanf("%d",&n);
    int a[n+1];
    printf("enter the array elements :");
    for(i=1;i<=n;i++)
        scanf("%d",&a[i]);
    max=a[1];
    for(i=1;i<=n;i++)
    {
        m=a[i];
        for(j=i+1;j<=n;j++)
        {
            if(m+a[j]>max)
            {
                max=a[j]+m;
                m+=a[j];
                c=i;
                d=j;
            }

            else
                m+=a[j];
        }
        if(a[i]>=max)
        {
            max=a[i];
            c=d=i;
        }
    }
    printf("\n\nThe largest sum is %d",max);
    printf("\n\nThe largest sum is found within [%d : %d]",c-1,d-1);
}
