import PageHeading from "../page-heading/PageHeading.jsx";
import ProductListing from "../product-listing/Product-Listing.jsx";
import products from "../../data/products.js";

const Home = () => {
    return (
        <div className="max-w-[1152px] mx-auto px-6 py-8">
            <PageHeading title="Explore Woodkin">
                Explore Woodkin is a platform for sharing and discovering woodworking
                projects.
            </PageHeading>
            <ProductListing products={products}/>
        </div>
    );
};

export default Home;