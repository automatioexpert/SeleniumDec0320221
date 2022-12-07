package constant;

public class PetServiceHost extends BaseHost {
    public static final String CREATE_PET = String.format("%s/v2/pet", getHost());
    public static final String UPDATE_PET = String.format("%s/v2/pet", getHost());
    public static final String FIND_PET_BY_STATUS = String.format("%s/v2/pet/findByStatus", getHost());
}
