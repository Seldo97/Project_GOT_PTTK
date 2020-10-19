package grupa4.projektzespolowy.GOTTPKProjekt.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public interface Mapper<DTO,ENTITY> {
	
DTO mapOfEntity(ENTITY entity);
	
	ENTITY mapOfDTO(DTO dto);
	
	public default Page<DTO> map(Page<ENTITY> entities)
	{
		return entities.map(this::mapOfEntity);
	}
	
	public default List<DTO> mapOfCollection(Collection<ENTITY> entity)
	{
		return entity
		.stream()
		.map(this::mapOfEntity)
		.collect(Collectors.toList());
	}
}
