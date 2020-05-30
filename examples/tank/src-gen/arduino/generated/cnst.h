#ifndef _cnst_h
#define _cnst_h 1

#define _c_T_H 0.1
#define _c_X_MIN 0.1
#define _c_X_MAX 0.5
#define _c_H 0.6
#define _c_U_MIN 0.0
#define _c_U_MAX 15.0
#define _c_DELTA_U 3.0
#define _c_K_P 31.2634
#define _c_K_I 0.4016

enum _e_COM2CA {
_e_em_COM2CA_XD=1, 
};
enum _e_CA2GUI {
_e_em_CA2GUI_X_LEVEL=0, 
_e_em_CA2GUI_U_LEVEL=1, 
};

#define _r_CLOCK (INT32_U) 50UL
#endif
