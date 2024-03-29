package ru.practicum.server.data;

public abstract class EntityData<K> {
    protected K id;

    public EntityData() {
    }

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof EntityData)) {
            return false;
        } else {
            EntityData that = (EntityData) o;
            if (!that.getClass().equals(this.getClass())) {
                return false;
            } else {
                return this.id != null && this.id.equals(that.id);
            }
        }
    }

    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "{id=" + this.id + '}';
    }
}