


    const BondDetail = (props) => {
        return (
            <tr>
                <td>{props.info.id}  </td>
                <td>{props.info.quantity}  </td>
                <td>{props.info.isin}  </td>
                <td>{props.info.cusip}</td>
            </tr>
          )
    }

export default BondDetail;