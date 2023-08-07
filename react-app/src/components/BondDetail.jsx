


    const BondDetail = (props) => {
        return (
            <div>
                 ___{props.info.id}_________{props.info.quantity}___________ {props.info.isin}___________
                {props.info.cusip}
            </div>
          )
    }

export default BondDetail;