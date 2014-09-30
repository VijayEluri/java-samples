package jp.co.np.p2netex.sample2.allcommon.cbean.mapping;

/**
 * The mapper of entity-to-dto.
 * @param <ENTITY> The type of entity.
 * @param <DTO> The type of dto.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2EntityDtoMapper<ENTITY, DTO> {

    /**
     * Map entity to data transfer object.
     * @param entity Entity. (NotNull)
     * @return Data transfer object. (NotNull)
     */
    public DTO map(ENTITY entity);
}
