//Class to enquee the tasks
class WorkItem {
    boolean val=false;
    int sum = 0;
    int Arow[];
    int Bcol[];
    int rowNum, colNum;//A_row & B_column indices

    public WorkItem(int r, int c, int Arow[], int Bcol[]) {
        this.Arow = Arow;
        this.Bcol = Bcol;
        rowNum = r;
        colNum = c;
    }
//method to get respective Matrix element

    int set() {
        return sum;
    }
//method to set respective Matrix element

    void calculate() {
        for (int i = 0; i < Arow.length; i++) {
            sum += Arow[i] * Bcol[i];
        }
    }
}
