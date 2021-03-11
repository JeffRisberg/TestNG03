package com.domain;

public enum CandidateType {
  Developer("developers"),
  ProjectManager("project_managers"),
  Designer("designers");

  private String selectionValue;

  CandidateType(String selectionValue) {
    this.selectionValue = selectionValue;
  }

  public String getSelectionValue() { return selectionValue; }
};
