package org.example.twenty_points.util;

import lombok.experimental.UtilityClass;

import org.hibernate.MappingException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@UtilityClass
public class Mapper {

    private static final ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setAmbiguityIgnored(true)
                .setSkipNullEnabled(false)
                .setPreferNestedProperties(false);
    }

    public static <S, D> D map(final S source, D destination){
        mapper.map(source, destination);
        return destination;
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        try {
            return mapper.map(entity, outClass);
        } catch (Exception e) {
            throw new MappingException(e);
        }
    }
}
