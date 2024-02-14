public class Minute implements ITimeService{
    private ITimeService next = null;
    @Override
    public void setNext(ITimeService next) {
        this.next=next;
    }

    @Override
    public void handleRequest(TimeRequest request, int value) {
        if (value < 60) {
            if(value > 1){
                request.setConclusion(value+" minutes");
            }else{
                request.setConclusion(value+" minute");
            }
        } else {
            if (next != null){
                int processedValue = value % 60;

                if(processedValue != 0){
                    if(processedValue > 1){
                        request.setConclusion(processedValue+" minutes");
                    }else {
                        request.setConclusion(processedValue+ " minute");
                    }
                }
                next.handleRequest(request,value / 60);

            }
        }
    }
}
