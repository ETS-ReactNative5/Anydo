import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import "./DenseAppBar.css";


const styles = {
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginLeft: -18,
    marginRight: 10,
  },
};

function DenseAppBar(props) {
  const { classes } = props;
  return (
    <div className={classes.root}>
      <AppBar position="static" color="white" height="18px">
        <Toolbar variant="dense">
          <IconButton className={classes.menuButton} color="inherit" aria-label="Menu">
            <MenuIcon onClick={props.click}/>
            </IconButton>
            <button className="button" onClick={props.showListHandler}>
            <strong>+ New</strong>
            </button>
            <div className= "position">
            <button className="button"
                    onClick={props.onLogout}
                  >
                    Log Out
                  </button>
                  </div>
        </Toolbar>
      </AppBar>
    </div>
  );
}


export default withStyles(styles)(DenseAppBar);
