import { Link } from "react-router-dom";

const LandingPage = () => {
    return ( 
        <div className="landing-page">
           <Link to={Cre}>
            create
           </Link>
            <br />
            <Link to={<>}>
            read
           </Link>
           <br />
           <Link to={<>}>
            update
           </Link>
            <br />
            <Link to={<>}>
            delete
           </Link>
            <br />
            </div>
     );
}
 
export default LandingPage;