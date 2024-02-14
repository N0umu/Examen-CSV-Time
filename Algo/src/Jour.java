public class Jour implements ITimeService{
    private ITimeService next = null;
    @Override
    public void setNext(ITimeService next) {
        this.next=next;
    }

    @Override
    public void handleRequest(TimeRequest request, int value) {
        if (value < 365) {
            if(value > 1){
                request.setConclusion(value+" jours");
            }else{
                request.setConclusion(value+" jour");
            }
        } else {
            if (next != null){
                int processedValue = value % 365;

                if(processedValue != 0){
                    if(processedValue > 1){
                        request.setConclusion(processedValue+" jours");
                    }else {
                        request.setConclusion(processedValue+ " jour");
                    }
                }
                next.handleRequest(request,value / 365);

            }
        }
    }
}
