package org.example.models.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

private String uuid;
  private String name;
  private String description;
  private int urgency;
  private int importance;
  private String colorCategory;
  private List<String> tags;
  private LocalDateTime createLocalDateTime;
  private List<LocalDateTime> listOfLocalDateTimes;

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("uuid", uuid)
            .append("name", name)
            .append("description", description)
            .append("urgency", urgency)
            .append("importance", importance)
            .append("colorCategory", colorCategory)
            .append("tags", tags)
            .append("createLocalDateTime", createLocalDateTime)
            .append("listOfLocalDateTimes", listOfLocalDateTimes)
            .toString();
  }
}
