
package sample.xfire;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import com.amazon.webservices.awseCommerceService.x20060628.BrowseNodeLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.BrowseNodeLookupResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartAddDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartAddResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartClearDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartClearResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartCreateDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartCreateResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartGetDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartGetResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartModifyDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CartModifyResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CustomerContentLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CustomerContentLookupResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CustomerContentSearchDocument;
import com.amazon.webservices.awseCommerceService.x20060628.CustomerContentSearchResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.HelpDocument;
import com.amazon.webservices.awseCommerceService.x20060628.HelpResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ItemLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ItemLookupResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ItemSearchDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ItemSearchResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ListLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ListLookupResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ListSearchDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ListSearchResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.MultiOperationDocument;
import com.amazon.webservices.awseCommerceService.x20060628.MultiOperationResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SellerListingLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SellerListingLookupResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SellerListingSearchDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SellerListingSearchResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SellerLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SellerLookupResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SimilarityLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.SimilarityLookupResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.TransactionLookupDocument;
import com.amazon.webservices.awseCommerceService.x20060628.TransactionLookupResponseDocument;

@WebService(name = "AWSECommerceServicePortType", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface AWSECommerceServicePortType {


    @WebMethod(operationName = "ItemSearch", action = "http://soap.amazon.com")
    @WebResult(name = "ItemSearchResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public ItemSearchResponseDocument itemSearch(
        @WebParam(name = "ItemSearch", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        ItemSearchDocument ItemSearch);

    @WebMethod(operationName = "CustomerContentSearch", action = "http://soap.amazon.com")
    @WebResult(name = "CustomerContentSearchResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public CustomerContentSearchResponseDocument customerContentSearch(
        @WebParam(name = "CustomerContentSearch", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        CustomerContentSearchDocument CustomerContentSearch);

    @WebMethod(operationName = "Help", action = "http://soap.amazon.com")
    @WebResult(name = "HelpResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public HelpResponseDocument help(
        @WebParam(name = "Help", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        HelpDocument Help);

    @WebMethod(operationName = "CartAdd", action = "http://soap.amazon.com")
    @WebResult(name = "CartAddResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public CartAddResponseDocument cartAdd(
        @WebParam(name = "CartAdd", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        CartAddDocument CartAdd);

    @WebMethod(operationName = "ItemLookup", action = "http://soap.amazon.com")
    @WebResult(name = "ItemLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public ItemLookupResponseDocument itemLookup(
        @WebParam(name = "ItemLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        ItemLookupDocument ItemLookup);

    @WebMethod(operationName = "CartGet", action = "http://soap.amazon.com")
    @WebResult(name = "CartGetResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public CartGetResponseDocument cartGet(
        @WebParam(name = "CartGet", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        CartGetDocument CartGet);

    @WebMethod(operationName = "CartModify", action = "http://soap.amazon.com")
    @WebResult(name = "CartModifyResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public CartModifyResponseDocument cartModify(
        @WebParam(name = "CartModify", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        CartModifyDocument CartModify);

    @WebMethod(operationName = "CartClear", action = "http://soap.amazon.com")
    @WebResult(name = "CartClearResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public CartClearResponseDocument cartClear(
        @WebParam(name = "CartClear", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        CartClearDocument CartClear);

    @WebMethod(operationName = "SimilarityLookup", action = "http://soap.amazon.com")
    @WebResult(name = "SimilarityLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public SimilarityLookupResponseDocument similarityLookup(
        @WebParam(name = "SimilarityLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        SimilarityLookupDocument SimilarityLookup);

    @WebMethod(operationName = "SellerListingLookup", action = "http://soap.amazon.com")
    @WebResult(name = "SellerListingLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public SellerListingLookupResponseDocument sellerListingLookup(
        @WebParam(name = "SellerListingLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        SellerListingLookupDocument SellerListingLookup);

    @WebMethod(operationName = "SellerLookup", action = "http://soap.amazon.com")
    @WebResult(name = "SellerLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public SellerLookupResponseDocument sellerLookup(
        @WebParam(name = "SellerLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        SellerLookupDocument SellerLookup);

    @WebMethod(operationName = "BrowseNodeLookup", action = "http://soap.amazon.com")
    @WebResult(name = "BrowseNodeLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public BrowseNodeLookupResponseDocument browseNodeLookup(
        @WebParam(name = "BrowseNodeLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        BrowseNodeLookupDocument BrowseNodeLookup);

    @WebMethod(operationName = "TransactionLookup", action = "http://soap.amazon.com")
    @WebResult(name = "TransactionLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public TransactionLookupResponseDocument transactionLookup(
        @WebParam(name = "TransactionLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        TransactionLookupDocument TransactionLookup);

    @WebMethod(operationName = "SellerListingSearch", action = "http://soap.amazon.com")
    @WebResult(name = "SellerListingSearchResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public SellerListingSearchResponseDocument sellerListingSearch(
        @WebParam(name = "SellerListingSearch", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        SellerListingSearchDocument SellerListingSearch);

    @WebMethod(operationName = "ListSearch", action = "http://soap.amazon.com")
    @WebResult(name = "ListSearchResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public ListSearchResponseDocument listSearch(
        @WebParam(name = "ListSearch", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        ListSearchDocument ListSearch);

    @WebMethod(operationName = "CustomerContentLookup", action = "http://soap.amazon.com")
    @WebResult(name = "CustomerContentLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public CustomerContentLookupResponseDocument customerContentLookup(
        @WebParam(name = "CustomerContentLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        CustomerContentLookupDocument CustomerContentLookup);

    @WebMethod(operationName = "ListLookup", action = "http://soap.amazon.com")
    @WebResult(name = "ListLookupResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public ListLookupResponseDocument listLookup(
        @WebParam(name = "ListLookup", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        ListLookupDocument ListLookup);

    @WebMethod(operationName = "MultiOperation", action = "http://soap.amazon.com")
    @WebResult(name = "MultiOperationResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public MultiOperationResponseDocument multiOperation(
        @WebParam(name = "MultiOperation", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        MultiOperationDocument MultiOperation);

    @WebMethod(operationName = "CartCreate", action = "http://soap.amazon.com")
    @WebResult(name = "CartCreateResponse", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
    public CartCreateResponseDocument cartCreate(
        @WebParam(name = "CartCreate", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2006-06-28")
        CartCreateDocument CartCreate);

}
