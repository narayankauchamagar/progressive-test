package np.com.thapanarayan.progressivelab.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ServerResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
