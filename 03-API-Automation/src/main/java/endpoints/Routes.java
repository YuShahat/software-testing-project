package endpoints;

public class Routes {

    private Routes() {
        // Prevent object creation
    }

    // Products
    public static final String PRODUCTS_LIST =
            "/api/productsList";

    // Brands
    public static final String BRANDS_LIST =
            "/api/brandsList";

    // Search Product
    public static final String SEARCH_PRODUCT =
            "/api/searchProduct";

    // Authentication
    public static final String VERIFY_LOGIN =
            "/api/verifyLogin";

    // Account
    public static final String CREATE_ACCOUNT =
            "/api/createAccount";

    public static final String UPDATE_ACCOUNT =
            "/api/updateAccount";

    public static final String DELETE_ACCOUNT =
            "/api/deleteAccount";

    public static final String GET_USER_DETAIL =
            "/api/getUserDetailByEmail";
}