package br.com.hyper.HyperCar.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerConverter {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    public static <O,D> D parseObject(O origem, Class<D> destination){
        return mapper
                .map(origem, destination);
    }

    public static <O,D> List<D>
    parseListObjects(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for (Object o: origin
             ) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
