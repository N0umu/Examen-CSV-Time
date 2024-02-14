import java.util.ArrayList;

public class TimeRequest {
    private int request = 0;
    private ArrayList<String> conclusion = new ArrayList<>();

    public TimeRequest(int request) {
        this.request = request;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public ArrayList<String> getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion.add(conclusion);
    }

    public String getProcessedConclusion(){
        StringBuilder processedConclusion = new StringBuilder();
        for(int i = conclusion.size()-1; i >= 0; i--){
            processedConclusion.append(conclusion.get(i));
            if(i > 1){
                processedConclusion.append(", ");

            }else if(i == 1){
                processedConclusion.append(" et ");
            }
        }
        return processedConclusion.toString();
    }
}