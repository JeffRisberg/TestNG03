package com.domain;

public class Candidate {

  public CandidateType type;
  public String firstName;
  public String lastName;
  public String email;
  public String password;

  public String getFullName() {
    return firstName + " " + lastName;
  }
}
