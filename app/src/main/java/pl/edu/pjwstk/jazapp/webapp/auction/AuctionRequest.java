package pl.edu.pjwstk.jazapp.webapp.auction;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionRequest {

    private String description;
    private int sectionId;
    private int  price;

    @Inject
    AuctionRepository auctionRepository;

    public boolean createAuction(){
        System.out.println("KROK 0 <-------------------------------");
        AuctionEntity auctionEntity = new AuctionEntity(description,sectionId, price);
        System.out.println("KROK 00 <-------------------------------");
        auctionRepository.createAuction(auctionEntity);
        System.out.println("KROK 1 <-------------------------------");
        return true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AuctionRepository getAuctionRepository() {
        return auctionRepository;
    }

    public void setAuctionRepository(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }
}
