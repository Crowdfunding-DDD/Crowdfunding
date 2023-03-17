package fr.esgi.crowdfunding.exposition.mappers;

import java.util.Collection;
import java.util.List;

public interface GenericDtoMapper<D, T> {
    T toDto(D domain);

    D toDomain(T dto);

    List<T> toDto(Collection<D> domain);

    List<D> toDomain(Collection<T> dto);
}
