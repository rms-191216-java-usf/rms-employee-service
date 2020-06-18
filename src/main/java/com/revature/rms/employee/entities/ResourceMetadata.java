package com.revature.rms.employee.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ResourceMetadata {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int resourceId;

    @Column(nullable=false)
    private int resourceCreator;

    @Column(nullable=false)
    private String resourceCreationDateTime;

    @Column(nullable=false)
    private int lastModifier;

    @Column(nullable=false)
    private String lastModifiedDateTime;

    @Column(nullable=false)
    private int resourceOwner;

    @Column
    private boolean isActive;

    public ResourceMetadata() {
        super();
    }

    public ResourceMetadata(int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean isActive) {
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.isActive = isActive;
    }

    public ResourceMetadata(int resourceId, int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean isActive) {
        this.resourceId = resourceId;
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.isActive = isActive;
    }

    public ResourceMetadata(int resourceCreator, int lastModifier, int resourceOwner) {
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = LocalDateTime.now().toString();
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = LocalDateTime.now().toString();
        this.resourceOwner = resourceOwner;
    }

    public ResourceMetadata(int lastModifier, int resourceOwner) {
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = LocalDateTime.now().toString();
        this.resourceOwner = resourceOwner;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceCreator() {
        return resourceCreator;
    }

    public void setResourceCreator(int resourceCreator) {
        this.resourceCreator = resourceCreator;
    }

    public String getResourceCreationDateTime() {
        return resourceCreationDateTime;
    }

    public void setResourceCreationDateTime(String resourceCreationDateTime) {
        this.resourceCreationDateTime = resourceCreationDateTime;
    }

    public int getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(int lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public int getResourceOwner() {
        return resourceOwner;
    }

    public void setResourceOwner(int resourceOwner) {
        this.resourceOwner = resourceOwner;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceMetadata that = (ResourceMetadata) o;
        return resourceId == that.resourceId &&
                resourceCreator == that.resourceCreator &&
                lastModifier == that.lastModifier &&
                resourceOwner == that.resourceOwner &&
                isActive == that.isActive &&
                Objects.equals(resourceCreationDateTime, that.resourceCreationDateTime) &&
                Objects.equals(lastModifiedDateTime, that.lastModifiedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, resourceCreator, resourceCreationDateTime, lastModifier, lastModifiedDateTime, resourceOwner, isActive);
    }

    @Override
    public String toString() {
        return "ResourceMetadata{" +
                "resourceId=" + resourceId +
                ", resourceCreator=" + resourceCreator +
                ", resourceCreationDateTime='" + resourceCreationDateTime + '\'' +
                ", lastModifier=" + lastModifier +
                ", lastModifiedDateTime='" + lastModifiedDateTime + '\'' +
                ", resourceOwner=" + resourceOwner +
                ", isActive=" + isActive +
                '}';
    }
}
