import PageHeading from "../page-heading/PageHeading.jsx";
import ProductListing from "../product-listing/Product-Listing.jsx";
import {useEffect, useState} from "react";
import apiClient from "../../api/apiClient.js";

const Home = () => {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchProducts();
    }, []);

    const fetchProducts = async () => {
        try {
            setLoading(true);
            const response = await apiClient.get("/products");
            setProducts(response.data);
        } catch (error) {
            setError(
                error.response?.data?.message ||
                "Failed to fetch products. Please try again."
            );
        } finally {
            setLoading(false);
        }
    };

    if (loading) {
        return (
            <div className="flex items-center justify-center min-h-screen">
                <span className="text-xl font-semibold">Loading...</span>
            </div>
        );
    }

    if (error) {
        return (
            <div className="flex items-center justify-center min-h-screen">
                <span className="text-xl text-red-500">Error: {error}</span>
            </div>
        );
    }

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