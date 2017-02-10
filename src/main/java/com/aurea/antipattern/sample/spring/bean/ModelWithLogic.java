package com.aurea.antipattern.sample.spring.bean;

import java.util.Date;

public class ModelWithLogic {
  private Long id;
  private String description;
  private Date created;
  private boolean enabled;
  private Double progress; 
  
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Date getCreated() {
    return created;
  }
  public void setCreated(Date created) {
    this.created = created;
  }
  public boolean isEnabled() {
    return enabled;
  }
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
  
  @Override
  public String toString() {
    return "Model:" + description;
  }
  
  public Double getProgress() {
    return progress;
  }
  
  public void setProgress(Double progress) {
    this.progress = progress;
  }
  
  /**
   * Logic method that calculates a progress of the Model.
   */
  public void calculateProgress() {    
    Date today = new Date();
    this.progress = today.getTime() / 100d;
  }

  /**
   * Logic that return if the model finished.
   * @return
   */
  public boolean isFinished() {
    
    if ( this.progress.equals(100d)){
       return true;
    } else {
      return false;
    }
  }
  
  
}
