


    const BondDetail = (props) => {
        return (
            <div>
                {props.info.id}, {props.info.quantity}, {props.info.isin},
                {props.info.cusip}, {props.info.trade_date}
            </div>
          )
    }

export default BondDetail;