package com.domain;

public class CandidateFixture {

  public static Candidate getCandidate() {
    Candidate candidate = new Candidate();

    candidate.type = CandidateType.Designer;
    candidate.firstName = "Bob";
    candidate.lastName = "Jones";
    candidate.email = "bjones@gmail.com";
    candidate.password = "12345678";

    return candidate;
  }
}
