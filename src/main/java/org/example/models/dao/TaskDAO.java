package org.example.models.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**ABOUT UUID
 *There are two different ways of generating a UUID.
 If you just need a unique ID, you want a version 1 or version 4.
 Version 1: This generates a unique ID based on a network card MAC address and a timer. These IDs are easy to predict (given one, I might be able to guess another one) and can be traced back to your network card. It's not recommended to create these.
 Version 4: These are generated from random (or pseudo-random) numbers. If you just need to generate a UUID, this is probably what you want.

 If you need to always generate the same UUID from a given name, you want a version 3 or version 5.
 Version 3: This generates a unique ID from an MD5 hash of a namespace and name. If you need backwards compatibility (with another system that generates UUIDs from names), use this.
 Version 5: This generates a unique ID from an SHA-1 hash of a namespace and name. This is the preferred version.

 *
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskDAO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid1")
  @GenericGenerator(name = "uuid1", strategy = "uuid1")
  @Column(length = 36)
  private String uuid;

  @NotNull
  private String name;
  private String description;

  private int urgency;
  private int importance;
  private String colorCategory;
  @ElementCollection
  private List<String> tagStrings;

  @CreationTimestamp
  private LocalDateTime createLocalDateTime;
  @UpdateTimestamp
  private LocalDateTime updateLocalDateTime;
  @ElementCollection
  private List<LocalDateTime> listOfLocalDateTimes;

//https://thoughts-on-java.org/hibernate-tips-elementcollection/
 // https://youtrack.jetbrains.com/issue/IDEA-125306
//  //  @JsonIgnore
//  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//  @JoinTable(name = "hotel_room", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
//  private List<Room> rooms;
//
//  // @JsonIgnore
//  @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//  private Address address;



}
