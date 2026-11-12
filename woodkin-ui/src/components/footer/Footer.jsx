import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faHeart} from "@fortawesome/free-solid-svg-icons";

const Footer = () => {
    return (
        <footer className="flex justify-center items-center py-4 font-primary text-gray-700">
            Built with <FontAwesomeIcon icon={faHeart} className="text-red-600 mx-1 animate-pulse" aria-hidden="true"/>
            by <a href="https://nolanjames.me" target="_blank" rel="noopener noreferrer"
                  className="text-primary font-semibold px-1 transition-colors duration-300 hover:text-dark">Nolan
            James</a>
        </footer>
    );
};

export default Footer;