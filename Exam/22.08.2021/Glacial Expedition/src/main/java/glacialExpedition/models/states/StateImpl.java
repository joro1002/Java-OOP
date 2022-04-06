package glacialExpedition.models.states;

import java.security.cert.CertificateParsingException;
import java.util.Collection;

public class StateImpl implements State{
    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name){
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
