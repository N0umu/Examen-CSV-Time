public class Seconde implements ITimeService{
    private ITimeService next = null;
    @Override
    public void setNext(ITimeService next) {
        this.next=next;
    }

    @Override
    public void handleRequest(TimeRequest request, int value) {
        if (value < 60) {
            if(value <= 0){
                request.setConclusion("now");
            }else{
                if(value > 1){
                    request.setConclusion(value+" secondes");
                }else{
                    request.setConclusion(value+" seconde");
                }
            }
        } else {
            if (next != null){
                int processedValue = value % 60;

                if(processedValue != 0){
                    if(processedValue > 1){
                        request.setConclusion(processedValue +" secondes");
                    }else{
                        request.setConclusion(processedValue +" seconde");
                    }
                }
                next.handleRequest(request,value / 60);
            }
        }
    }
}
