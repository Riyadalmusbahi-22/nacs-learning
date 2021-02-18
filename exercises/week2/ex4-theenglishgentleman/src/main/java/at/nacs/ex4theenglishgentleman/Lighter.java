package at.nacs.ex4theenglishgentleman;

import org.springframework.stereotype.Component;

@Component
public class Lighter {
    
    public void light(Cigar cigar) {
        cigar.setLit(true);
    }
}
