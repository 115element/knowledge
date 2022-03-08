package com.study_guava.graph.bean;

public class DataEntity implements Node<DataEntity> {

    private final String nameSpace;
    private final String entityName;

    public DataEntity(String nameSpace, String entityName) {
        super();
        this.nameSpace = nameSpace;
        this.entityName = entityName;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DataEntity other = (DataEntity) obj;
        if (entityName == null) {
            if (other.entityName != null) {
                return false;
            }
        } else if (!entityName.equals(other.entityName)) {
            return false;
        }
        if (nameSpace == null) {
            if (other.nameSpace != null) {
                return false;
            }
        } else if (!nameSpace.equals(other.nameSpace)) {
            return false;
        }
        return true;
    }

    @Override
    public DataEntity get() {
        return null;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public String getEntityName() {
        return entityName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
        result = prime * result + ((nameSpace == null) ? 0 : nameSpace.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "nameSpace='" + nameSpace + '\'' +
                ", entityName='" + entityName + '\'' +
                '}';
    }
}
