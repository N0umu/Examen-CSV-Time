public class Heure implements ITimeService{
    private ITimeService next = null;
    @Override
    public void setNext(ITimeService next) {
        this.next=next;
    }

    @Override
    public void handleRequest(TimeRequest request , int value) {
        if (value < 24) {
            if(value > 1){
                request.setConclusion(value+" heures");
            }else{
                request.setConclusion(value+" heure");
            }
        } else {
            if (next != null){
                int processedValue = value % 24;

                if(processedValue != 0){
                    if(processedValue > 1){
                        request.setConclusion(processedValue+" heures");
                    }else {
                        request.setConclusion(processedValue+ " heure");
                    }
                }
                next.handleRequest(request,value / 24);

            }
        }
    }
}
