package com.study_guava.graph.bean;


public class DataRelationShip implements Edge<DataRelationShip> {

    private final String sourceColumn;
    private final String targetColumn;

    public DataRelationShip(String sourceColumn, String targetColumn) {
        super();
        this.sourceColumn = sourceColumn;
        this.targetColumn = targetColumn;
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
        DataRelationShip other = (DataRelationShip) obj;
        if (sourceColumn == null) {
            if (other.sourceColumn != null) {
                return false;
            }
        } else if (!sourceColumn.equals(other.sourceColumn)) {
            return false;
        }
        if (targetColumn == null) {
            if (other.targetColumn != null) {
                return false;
            }
        } else if (!targetColumn.equals(other.targetColumn)) {
            return false;
        }
        return true;
    }

    @Override
    public DataRelationShip get() {
        return this;
    }

    public String getSourceColumn() {
        return sourceColumn;
    }

    public String getTargetColumn() {
        return targetColumn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sourceColumn == null) ? 0 : sourceColumn.hashCode());
        result = prime * result + ((targetColumn == null) ? 0 : targetColumn.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DataRelationShip [sourceColumn=" + sourceColumn + ", targetColumn=" + targetColumn + "]";
    }

}