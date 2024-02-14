public class Annee implements ITimeService{
    private ITimeService next = null;
    @Override
    public void setNext(ITimeService next) {
        this.next=next;
    }

    @Override
    public void handleRequest(TimeRequest request, int value) {
        if(value > 1){
            request.setConclusion(value+" ans");
        }else{
            request.setConclusion(value+" an");
        }
        if (next != null){
            System.out.println("PROBLEME");
        }
    }
}
