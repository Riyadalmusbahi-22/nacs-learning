package at.nacs.fengshuiprofiler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    private Profile profile1;
    private Profile profile2;
    private String signCompatibility;
    private String loveCompatibility;

}
