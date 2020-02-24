package ru.iaie.reflex.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ru.iaie.reflex.services.ReflexGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalReflexParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TACT", "RULE_REG_SIZE", "RULE_VOID_C_TYPE", "RULE_FLOAT_C_TYPE", "RULE_DOUBLE_C_TYPE", "RULE_SHORT_C_TYPE", "RULE_INT_C_TYPE", "RULE_LONG_C_TYPE", "RULE_BOOL_TYPE", "RULE_DECIMAL", "RULE_OCTAL", "RULE_HEX", "RULE_LONG", "RULE_UNSIGNED", "RULE_DAY", "RULE_HOUR", "RULE_MINUTE", "RULE_SECOND", "RULE_MILISECOND", "RULE_MICROSECOND", "RULE_NANOSECOND", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'program'", "'{'", "'}'", "'proc'", "';'", "'from'", "'='", "','", "'['", "']'", "'local'", "'global'", "'shared'", "'state'", "'timeout'", "'if'", "'('", "')'", "'else'", "'switch'", "'case'", "':'", "'break'", "'start'", "'stop'", "'error'", "'loop'", "'restart'", "'set'", "'next'", "'const'", "'enum'", "'0t'", "'0T'", "'input'", "'output'", "'signed'", "'unsigned'"
    };
    public static final int RULE_BOOL_TYPE=13;
    public static final int RULE_HEX=16;
    public static final int T__50=50;
    public static final int RULE_DAY=19;
    public static final int RULE_REG_SIZE=6;
    public static final int RULE_FLOAT_C_TYPE=8;
    public static final int RULE_OCTAL=15;
    public static final int RULE_MINUTE=21;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_TACT=5;
    public static final int RULE_INT_C_TYPE=11;
    public static final int RULE_SHORT_C_TYPE=10;
    public static final int RULE_DECIMAL=14;
    public static final int RULE_SECOND=22;
    public static final int RULE_INT=26;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=28;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_LONG_C_TYPE=12;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_NANOSECOND=25;
    public static final int RULE_MILISECOND=23;
    public static final int RULE_STRING=27;
    public static final int RULE_SL_COMMENT=29;
    public static final int RULE_MICROSECOND=24;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int RULE_VOID_C_TYPE=7;
    public static final int T__32=32;
    public static final int RULE_HOUR=20;
    public static final int RULE_UNSIGNED=18;
    public static final int RULE_WS=30;
    public static final int RULE_DOUBLE_C_TYPE=9;
    public static final int RULE_ANY_OTHER=31;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_LONG=17;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalReflexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReflexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReflexParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReflex.g"; }



     	private ReflexGrammarAccess grammarAccess;

        public InternalReflexParser(TokenStream input, ReflexGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected ReflexGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalReflex.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalReflex.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalReflex.g:66:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalReflex.g:72:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_ticks_3_0=null;
        Token otherlv_9=null;
        EObject lv_consts_4_0 = null;

        EObject lv_enums_5_0 = null;

        EObject lv_functions_6_0 = null;

        EObject lv_registers_7_0 = null;

        EObject lv_processes_8_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:78:2: ( (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' ) )
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' )
            {
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' )
            // InternalReflex.g:80:3: otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getProgramKeyword_0());
              		
            }
            // InternalReflex.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:106:3: ( (lv_ticks_3_0= RULE_TACT ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_TACT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:107:4: (lv_ticks_3_0= RULE_TACT )
                    {
                    // InternalReflex.g:107:4: (lv_ticks_3_0= RULE_TACT )
                    // InternalReflex.g:108:5: lv_ticks_3_0= RULE_TACT
                    {
                    lv_ticks_3_0=(Token)match(input,RULE_TACT,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_ticks_3_0, grammarAccess.getProgramAccess().getTicksTACTTerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getProgramRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"ticks",
                      						true,
                      						"ru.iaie.reflex.Reflex.TACT");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:124:3: ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )*
            loop2:
            do {
                int alt2=6;
                switch ( input.LA(1) ) {
                case 62:
                    {
                    alt2=1;
                    }
                    break;
                case 63:
                    {
                    alt2=2;
                    }
                    break;
                case RULE_VOID_C_TYPE:
                case RULE_FLOAT_C_TYPE:
                case RULE_DOUBLE_C_TYPE:
                case RULE_SHORT_C_TYPE:
                case RULE_INT_C_TYPE:
                case RULE_LONG_C_TYPE:
                case 68:
                case 69:
                    {
                    alt2=3;
                    }
                    break;
                case 66:
                case 67:
                    {
                    alt2=4;
                    }
                    break;
                case 35:
                    {
                    alt2=5;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:125:4: ( (lv_consts_4_0= ruleConst ) )
            	    {
            	    // InternalReflex.g:125:4: ( (lv_consts_4_0= ruleConst ) )
            	    // InternalReflex.g:126:5: (lv_consts_4_0= ruleConst )
            	    {
            	    // InternalReflex.g:126:5: (lv_consts_4_0= ruleConst )
            	    // InternalReflex.g:127:6: lv_consts_4_0= ruleConst
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getConstsConstParserRuleCall_4_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_consts_4_0=ruleConst();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"consts",
            	      							lv_consts_4_0,
            	      							"ru.iaie.reflex.Reflex.Const");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalReflex.g:145:4: ( (lv_enums_5_0= ruleEnum ) )
            	    {
            	    // InternalReflex.g:145:4: ( (lv_enums_5_0= ruleEnum ) )
            	    // InternalReflex.g:146:5: (lv_enums_5_0= ruleEnum )
            	    {
            	    // InternalReflex.g:146:5: (lv_enums_5_0= ruleEnum )
            	    // InternalReflex.g:147:6: lv_enums_5_0= ruleEnum
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getEnumsEnumParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_enums_5_0=ruleEnum();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enums",
            	      							lv_enums_5_0,
            	      							"ru.iaie.reflex.Reflex.Enum");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalReflex.g:165:4: ( (lv_functions_6_0= ruleFunction ) )
            	    {
            	    // InternalReflex.g:165:4: ( (lv_functions_6_0= ruleFunction ) )
            	    // InternalReflex.g:166:5: (lv_functions_6_0= ruleFunction )
            	    {
            	    // InternalReflex.g:166:5: (lv_functions_6_0= ruleFunction )
            	    // InternalReflex.g:167:6: lv_functions_6_0= ruleFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getFunctionsFunctionParserRuleCall_4_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_functions_6_0=ruleFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_6_0,
            	      							"ru.iaie.reflex.Reflex.Function");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalReflex.g:185:4: ( (lv_registers_7_0= ruleRegister ) )
            	    {
            	    // InternalReflex.g:185:4: ( (lv_registers_7_0= ruleRegister ) )
            	    // InternalReflex.g:186:5: (lv_registers_7_0= ruleRegister )
            	    {
            	    // InternalReflex.g:186:5: (lv_registers_7_0= ruleRegister )
            	    // InternalReflex.g:187:6: lv_registers_7_0= ruleRegister
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getRegistersRegisterParserRuleCall_4_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_registers_7_0=ruleRegister();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"registers",
            	      							lv_registers_7_0,
            	      							"ru.iaie.reflex.Reflex.Register");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalReflex.g:205:4: ( (lv_processes_8_0= ruleProcess ) )
            	    {
            	    // InternalReflex.g:205:4: ( (lv_processes_8_0= ruleProcess ) )
            	    // InternalReflex.g:206:5: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalReflex.g:206:5: (lv_processes_8_0= ruleProcess )
            	    // InternalReflex.g:207:6: lv_processes_8_0= ruleProcess
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_4_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_processes_8_0=ruleProcess();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"processes",
            	      							lv_processes_8_0,
            	      							"ru.iaie.reflex.Reflex.Process");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_9=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleProcess"
    // InternalReflex.g:233:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalReflex.g:233:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalReflex.g:234:2: iv_ruleProcess= ruleProcess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalReflex.g:240:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_variable_3_0 = null;

        EObject lv_states_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:246:2: ( (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' ) )
            // InternalReflex.g:247:2: (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' )
            {
            // InternalReflex.g:247:2: (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' )
            // InternalReflex.g:248:3: otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getProcKeyword_0());
              		
            }
            // InternalReflex.g:252:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:253:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:253:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:254:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProcessRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:274:3: ( (lv_variable_3_0= ruleVariable ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_VOID_C_TYPE && LA3_0<=RULE_BOOL_TYPE)||LA3_0==37||(LA3_0>=68 && LA3_0<=69)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReflex.g:275:4: (lv_variable_3_0= ruleVariable )
            	    {
            	    // InternalReflex.g:275:4: (lv_variable_3_0= ruleVariable )
            	    // InternalReflex.g:276:5: lv_variable_3_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getVariableVariableParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_variable_3_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"variable",
            	      						lv_variable_3_0,
            	      						"ru.iaie.reflex.Reflex.Variable");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalReflex.g:293:3: ( (lv_states_4_0= ruleState ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==45) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalReflex.g:294:4: (lv_states_4_0= ruleState )
            	    {
            	    // InternalReflex.g:294:4: (lv_states_4_0= ruleState )
            	    // InternalReflex.g:295:5: lv_states_4_0= ruleState
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_states_4_0=ruleState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"states",
            	      						lv_states_4_0,
            	      						"ru.iaie.reflex.Reflex.State");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleVariable"
    // InternalReflex.g:320:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalReflex.g:320:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalReflex.g:321:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalReflex.g:327:1: ruleVariable returns [EObject current=null] : (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ImportedVariable_0 = null;

        EObject this_DeclaredVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:333:2: ( (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) ) )
            // InternalReflex.g:334:2: (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) )
            {
            // InternalReflex.g:334:2: (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==37) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_VOID_C_TYPE && LA5_0<=RULE_BOOL_TYPE)||(LA5_0>=68 && LA5_0<=69)) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:335:3: this_ImportedVariable_0= ruleImportedVariable
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getVariableAccess().getImportedVariableParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ImportedVariable_0=ruleImportedVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ImportedVariable_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:344:3: (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' )
                    {
                    // InternalReflex.g:344:3: (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' )
                    // InternalReflex.g:345:4: this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVariableAccess().getDeclaredVariableParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_9);
                    this_DeclaredVariable_1=ruleDeclaredVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_DeclaredVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_2=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getSemicolonKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleImportedVariable"
    // InternalReflex.g:362:1: entryRuleImportedVariable returns [EObject current=null] : iv_ruleImportedVariable= ruleImportedVariable EOF ;
    public final EObject entryRuleImportedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedVariable = null;


        try {
            // InternalReflex.g:362:57: (iv_ruleImportedVariable= ruleImportedVariable EOF )
            // InternalReflex.g:363:2: iv_ruleImportedVariable= ruleImportedVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportedVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportedVariable=ruleImportedVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportedVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedVariable"


    // $ANTLR start "ruleImportedVariable"
    // InternalReflex.g:369:1: ruleImportedVariable returns [EObject current=null] : (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* ) ;
    public final EObject ruleImportedVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token lv_varNames_3_0=null;


        	enterRule();

        try {
            // InternalReflex.g:375:2: ( (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* ) )
            // InternalReflex.g:376:2: (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* )
            {
            // InternalReflex.g:376:2: (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* )
            // InternalReflex.g:377:3: otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,37,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableAccess().getFromKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,35,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getImportedVariableAccess().getProcKeyword_1());
              		
            }
            // InternalReflex.g:385:3: ( (lv_procId_2_0= RULE_ID ) )
            // InternalReflex.g:386:4: (lv_procId_2_0= RULE_ID )
            {
            // InternalReflex.g:386:4: (lv_procId_2_0= RULE_ID )
            // InternalReflex.g:387:5: lv_procId_2_0= RULE_ID
            {
            lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_procId_2_0, grammarAccess.getImportedVariableAccess().getProcIdIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportedVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"procId",
              						lv_procId_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:403:3: ( (lv_varNames_3_0= RULE_ID ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReflex.g:404:4: (lv_varNames_3_0= RULE_ID )
            	    {
            	    // InternalReflex.g:404:4: (lv_varNames_3_0= RULE_ID )
            	    // InternalReflex.g:405:5: lv_varNames_3_0= RULE_ID
            	    {
            	    lv_varNames_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(lv_varNames_3_0, grammarAccess.getImportedVariableAccess().getVarNamesIDTerminalRuleCall_3_0());
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getImportedVariableRule());
            	      					}
            	      					addWithLastConsumed(
            	      						current,
            	      						"varNames",
            	      						lv_varNames_3_0,
            	      						"org.eclipse.xtext.common.Terminals.ID");
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedVariable"


    // $ANTLR start "entryRuleDeclaredVariable"
    // InternalReflex.g:425:1: entryRuleDeclaredVariable returns [EObject current=null] : iv_ruleDeclaredVariable= ruleDeclaredVariable EOF ;
    public final EObject entryRuleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredVariable = null;


        try {
            // InternalReflex.g:425:57: (iv_ruleDeclaredVariable= ruleDeclaredVariable EOF )
            // InternalReflex.g:426:2: iv_ruleDeclaredVariable= ruleDeclaredVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaredVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredVariable=ruleDeclaredVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaredVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaredVariable"


    // $ANTLR start "ruleDeclaredVariable"
    // InternalReflex.g:432:1: ruleDeclaredVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) ;
    public final EObject ruleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;

        EObject lv_visibility_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:438:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) )
            // InternalReflex.g:439:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            {
            // InternalReflex.g:439:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            // InternalReflex.g:440:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) )
            {
            // InternalReflex.g:440:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt7=2;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==38) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=42 && LA7_6<=44)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT_C_TYPE:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==38) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=42 && LA7_6<=44)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==38) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=42 && LA7_6<=44)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                int LA7_4 = input.LA(2);

                if ( (LA7_4==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==38) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=42 && LA7_6<=44)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VOID_C_TYPE:
            case RULE_FLOAT_C_TYPE:
            case RULE_DOUBLE_C_TYPE:
            case 68:
            case 69:
                {
                alt7=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalReflex.g:441:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_12);
                    this_PhysicalVariable_0=rulePhysicalVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PhysicalVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:450:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_12);
                    this_ProgramVariable_1=ruleProgramVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ProgramVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:459:3: ( (lv_visibility_2_0= ruleVisibility ) )
            // InternalReflex.g:460:4: (lv_visibility_2_0= ruleVisibility )
            {
            // InternalReflex.g:460:4: (lv_visibility_2_0= ruleVisibility )
            // InternalReflex.g:461:5: lv_visibility_2_0= ruleVisibility
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaredVariableAccess().getVisibilityVisibilityParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_visibility_2_0=ruleVisibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeclaredVariableRule());
              					}
              					set(
              						current,
              						"visibility",
              						lv_visibility_2_0,
              						"ru.iaie.reflex.Reflex.Visibility");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaredVariable"


    // $ANTLR start "entryRulePhysicalVariable"
    // InternalReflex.g:482:1: entryRulePhysicalVariable returns [EObject current=null] : iv_rulePhysicalVariable= rulePhysicalVariable EOF ;
    public final EObject entryRulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalVariable = null;


        try {
            // InternalReflex.g:482:57: (iv_rulePhysicalVariable= rulePhysicalVariable EOF )
            // InternalReflex.g:483:2: iv_rulePhysicalVariable= rulePhysicalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPhysicalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePhysicalVariable=rulePhysicalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePhysicalVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicalVariable"


    // $ANTLR start "rulePhysicalVariable"
    // InternalReflex.g:489:1: rulePhysicalVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' ) ;
    public final EObject rulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_ports_4_0 = null;

        EObject lv_ports_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:495:2: ( ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' ) )
            // InternalReflex.g:496:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' )
            {
            // InternalReflex.g:496:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' )
            // InternalReflex.g:497:3: ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}'
            {
            // InternalReflex.g:497:3: ( (lv_type_0_0= ruleIntegerType ) )
            // InternalReflex.g:498:4: (lv_type_0_0= ruleIntegerType )
            {
            // InternalReflex.g:498:4: (lv_type_0_0= ruleIntegerType )
            // InternalReflex.g:499:5: lv_type_0_0= ruleIntegerType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getTypeIntegerTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.IntegerType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:516:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:517:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:517:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:518:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPhysicalVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPhysicalVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,33,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPhysicalVariableAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:542:3: ( (lv_ports_4_0= ruleRegisterPort ) )
            // InternalReflex.g:543:4: (lv_ports_4_0= ruleRegisterPort )
            {
            // InternalReflex.g:543:4: (lv_ports_4_0= ruleRegisterPort )
            // InternalReflex.g:544:5: lv_ports_4_0= ruleRegisterPort
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortsRegisterPortParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_ports_4_0=ruleRegisterPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					add(
              						current,
              						"ports",
              						lv_ports_4_0,
              						"ru.iaie.reflex.Reflex.RegisterPort");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:561:3: (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==39) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalReflex.g:562:4: otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) )
            	    {
            	    otherlv_5=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_5, grammarAccess.getPhysicalVariableAccess().getCommaKeyword_5_0());
            	      			
            	    }
            	    // InternalReflex.g:566:4: ( (lv_ports_6_0= ruleRegisterPort ) )
            	    // InternalReflex.g:567:5: (lv_ports_6_0= ruleRegisterPort )
            	    {
            	    // InternalReflex.g:567:5: (lv_ports_6_0= ruleRegisterPort )
            	    // InternalReflex.g:568:6: lv_ports_6_0= ruleRegisterPort
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortsRegisterPortParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_ports_6_0=ruleRegisterPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
            	      						}
            	      						add(
            	      							current,
            	      							"ports",
            	      							lv_ports_6_0,
            	      							"ru.iaie.reflex.Reflex.RegisterPort");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_7=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getPhysicalVariableAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicalVariable"


    // $ANTLR start "entryRuleRegisterPort"
    // InternalReflex.g:594:1: entryRuleRegisterPort returns [EObject current=null] : iv_ruleRegisterPort= ruleRegisterPort EOF ;
    public final EObject entryRuleRegisterPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterPort = null;


        try {
            // InternalReflex.g:594:53: (iv_ruleRegisterPort= ruleRegisterPort EOF )
            // InternalReflex.g:595:2: iv_ruleRegisterPort= ruleRegisterPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterPort=ruleRegisterPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterPort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegisterPort"


    // $ANTLR start "ruleRegisterPort"
    // InternalReflex.g:601:1: ruleRegisterPort returns [EObject current=null] : ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' ) ;
    public final EObject ruleRegisterPort() throws RecognitionException {
        EObject current = null;

        Token lv_regName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_port_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:607:2: ( ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' ) )
            // InternalReflex.g:608:2: ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' )
            {
            // InternalReflex.g:608:2: ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' )
            // InternalReflex.g:609:3: ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']'
            {
            // InternalReflex.g:609:3: ( (lv_regName_0_0= RULE_ID ) )
            // InternalReflex.g:610:4: (lv_regName_0_0= RULE_ID )
            {
            // InternalReflex.g:610:4: (lv_regName_0_0= RULE_ID )
            // InternalReflex.g:611:5: lv_regName_0_0= RULE_ID
            {
            lv_regName_0_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regName_0_0, grammarAccess.getRegisterPortAccess().getRegNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regName",
              						lv_regName_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,40,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRegisterPortAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalReflex.g:631:3: ( (lv_port_2_0= ruleInteger ) )
            // InternalReflex.g:632:4: (lv_port_2_0= ruleInteger )
            {
            // InternalReflex.g:632:4: (lv_port_2_0= ruleInteger )
            // InternalReflex.g:633:5: lv_port_2_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterPortAccess().getPortIntegerParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_port_2_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterPortRule());
              					}
              					set(
              						current,
              						"port",
              						lv_port_2_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRegisterPortAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterPort"


    // $ANTLR start "entryRuleProgramVariable"
    // InternalReflex.g:658:1: entryRuleProgramVariable returns [EObject current=null] : iv_ruleProgramVariable= ruleProgramVariable EOF ;
    public final EObject entryRuleProgramVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramVariable = null;


        try {
            // InternalReflex.g:658:56: (iv_ruleProgramVariable= ruleProgramVariable EOF )
            // InternalReflex.g:659:2: iv_ruleProgramVariable= ruleProgramVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgramVariable=ruleProgramVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramVariable"


    // $ANTLR start "ruleProgramVariable"
    // InternalReflex.g:665:1: ruleProgramVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProgramVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:671:2: ( ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:672:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:672:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalReflex.g:673:3: ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalReflex.g:673:3: ( (lv_type_0_0= ruleReflexType ) )
            // InternalReflex.g:674:4: (lv_type_0_0= ruleReflexType )
            {
            // InternalReflex.g:674:4: (lv_type_0_0= ruleReflexType )
            // InternalReflex.g:675:5: lv_type_0_0= ruleReflexType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramVariableAccess().getTypeReflexTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleReflexType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProgramVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.ReflexType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:692:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:693:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:693:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:694:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramVariable"


    // $ANTLR start "entryRuleVisibility"
    // InternalReflex.g:714:1: entryRuleVisibility returns [EObject current=null] : iv_ruleVisibility= ruleVisibility EOF ;
    public final EObject entryRuleVisibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibility = null;


        try {
            // InternalReflex.g:714:51: (iv_ruleVisibility= ruleVisibility EOF )
            // InternalReflex.g:715:2: iv_ruleVisibility= ruleVisibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVisibilityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVisibility=ruleVisibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVisibility; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVisibility"


    // $ANTLR start "ruleVisibility"
    // InternalReflex.g:721:1: ruleVisibility returns [EObject current=null] : ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) ) ;
    public final EObject ruleVisibility() throws RecognitionException {
        EObject current = null;

        Token lv_LOCAL_0_0=null;
        Token lv_GLOBAL_1_0=null;
        Token lv_SHARED_2_0=null;
        Token lv_sharingProcs_3_0=null;


        	enterRule();

        try {
            // InternalReflex.g:727:2: ( ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) ) )
            // InternalReflex.g:728:2: ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) )
            {
            // InternalReflex.g:728:2: ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt10=1;
                }
                break;
            case 43:
                {
                alt10=2;
                }
                break;
            case 44:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalReflex.g:729:3: ( (lv_LOCAL_0_0= 'local' ) )
                    {
                    // InternalReflex.g:729:3: ( (lv_LOCAL_0_0= 'local' ) )
                    // InternalReflex.g:730:4: (lv_LOCAL_0_0= 'local' )
                    {
                    // InternalReflex.g:730:4: (lv_LOCAL_0_0= 'local' )
                    // InternalReflex.g:731:5: lv_LOCAL_0_0= 'local'
                    {
                    lv_LOCAL_0_0=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_LOCAL_0_0, grammarAccess.getVisibilityAccess().getLOCALLocalKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVisibilityRule());
                      					}
                      					setWithLastConsumed(current, "LOCAL", lv_LOCAL_0_0, "local");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:744:3: ( (lv_GLOBAL_1_0= 'global' ) )
                    {
                    // InternalReflex.g:744:3: ( (lv_GLOBAL_1_0= 'global' ) )
                    // InternalReflex.g:745:4: (lv_GLOBAL_1_0= 'global' )
                    {
                    // InternalReflex.g:745:4: (lv_GLOBAL_1_0= 'global' )
                    // InternalReflex.g:746:5: lv_GLOBAL_1_0= 'global'
                    {
                    lv_GLOBAL_1_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_GLOBAL_1_0, grammarAccess.getVisibilityAccess().getGLOBALGlobalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVisibilityRule());
                      					}
                      					setWithLastConsumed(current, "GLOBAL", lv_GLOBAL_1_0, "global");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:759:3: ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* )
                    {
                    // InternalReflex.g:759:3: ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* )
                    // InternalReflex.g:760:4: ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )*
                    {
                    // InternalReflex.g:760:4: ( (lv_SHARED_2_0= 'shared' ) )
                    // InternalReflex.g:761:5: (lv_SHARED_2_0= 'shared' )
                    {
                    // InternalReflex.g:761:5: (lv_SHARED_2_0= 'shared' )
                    // InternalReflex.g:762:6: lv_SHARED_2_0= 'shared'
                    {
                    lv_SHARED_2_0=(Token)match(input,44,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_SHARED_2_0, grammarAccess.getVisibilityAccess().getSHAREDSharedKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVisibilityRule());
                      						}
                      						setWithLastConsumed(current, "SHARED", lv_SHARED_2_0, "shared");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:774:4: ( (lv_sharingProcs_3_0= RULE_ID ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalReflex.g:775:5: (lv_sharingProcs_3_0= RULE_ID )
                    	    {
                    	    // InternalReflex.g:775:5: (lv_sharingProcs_3_0= RULE_ID )
                    	    // InternalReflex.g:776:6: lv_sharingProcs_3_0= RULE_ID
                    	    {
                    	    lv_sharingProcs_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(lv_sharingProcs_3_0, grammarAccess.getVisibilityAccess().getSharingProcsIDTerminalRuleCall_2_1_0());
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElement(grammarAccess.getVisibilityRule());
                    	      						}
                    	      						addWithLastConsumed(
                    	      							current,
                    	      							"sharingProcs",
                    	      							lv_sharingProcs_3_0,
                    	      							"org.eclipse.xtext.common.Terminals.ID");
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "entryRuleState"
    // InternalReflex.g:797:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalReflex.g:797:46: (iv_ruleState= ruleState EOF )
            // InternalReflex.g:798:2: iv_ruleState= ruleState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleState; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalReflex.g:804:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStateFunction ) )? ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_stateFunction_3_0 = null;

        EObject lv_timeoutFunction_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:810:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStateFunction ) )? ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) )
            // InternalReflex.g:811:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStateFunction ) )? ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            {
            // InternalReflex.g:811:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStateFunction ) )? ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            // InternalReflex.g:812:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_stateFunction_3_0= ruleStateFunction ) )? ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
              		
            }
            // InternalReflex.g:816:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:817:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:817:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:818:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStateRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:838:3: ( (lv_stateFunction_3_0= ruleStateFunction ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==33||LA11_0==36||LA11_0==47||LA11_0==51||(LA11_0>=55 && LA11_0<=60)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalReflex.g:839:4: (lv_stateFunction_3_0= ruleStateFunction )
                    {
                    // InternalReflex.g:839:4: (lv_stateFunction_3_0= ruleStateFunction )
                    // InternalReflex.g:840:5: lv_stateFunction_3_0= ruleStateFunction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateAccess().getStateFunctionStateFunctionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_19);
                    lv_stateFunction_3_0=ruleStateFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStateRule());
                      					}
                      					set(
                      						current,
                      						"stateFunction",
                      						true,
                      						"ru.iaie.reflex.Reflex.StateFunction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:857:3: ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==46) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalReflex.g:858:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    {
                    // InternalReflex.g:858:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    // InternalReflex.g:859:5: lv_timeoutFunction_4_0= ruleTimeoutFunction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateAccess().getTimeoutFunctionTimeoutFunctionParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
                    lv_timeoutFunction_4_0=ruleTimeoutFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStateRule());
                      					}
                      					set(
                      						current,
                      						"timeoutFunction",
                      						true,
                      						"ru.iaie.reflex.Reflex.TimeoutFunction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleStateFunction"
    // InternalReflex.g:884:1: entryRuleStateFunction returns [EObject current=null] : iv_ruleStateFunction= ruleStateFunction EOF ;
    public final EObject entryRuleStateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateFunction = null;


        try {
            // InternalReflex.g:884:54: (iv_ruleStateFunction= ruleStateFunction EOF )
            // InternalReflex.g:885:2: iv_ruleStateFunction= ruleStateFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStateFunction=ruleStateFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateFunction"


    // $ANTLR start "ruleStateFunction"
    // InternalReflex.g:891:1: ruleStateFunction returns [EObject current=null] : ( (lv_body_0_0= ruleBody ) ) ;
    public final EObject ruleStateFunction() throws RecognitionException {
        EObject current = null;

        EObject lv_body_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:897:2: ( ( (lv_body_0_0= ruleBody ) ) )
            // InternalReflex.g:898:2: ( (lv_body_0_0= ruleBody ) )
            {
            // InternalReflex.g:898:2: ( (lv_body_0_0= ruleBody ) )
            // InternalReflex.g:899:3: (lv_body_0_0= ruleBody )
            {
            // InternalReflex.g:899:3: (lv_body_0_0= ruleBody )
            // InternalReflex.g:900:4: lv_body_0_0= ruleBody
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getStateFunctionAccess().getBodyBodyParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_body_0_0=ruleBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getStateFunctionRule());
              				}
              				set(
              					current,
              					"body",
              					lv_body_0_0,
              					"ru.iaie.reflex.Reflex.Body");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateFunction"


    // $ANTLR start "entryRuleTimeoutFunction"
    // InternalReflex.g:920:1: entryRuleTimeoutFunction returns [EObject current=null] : iv_ruleTimeoutFunction= ruleTimeoutFunction EOF ;
    public final EObject entryRuleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutFunction = null;


        try {
            // InternalReflex.g:920:56: (iv_ruleTimeoutFunction= ruleTimeoutFunction EOF )
            // InternalReflex.g:921:2: iv_ruleTimeoutFunction= ruleTimeoutFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeoutFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTimeoutFunction=ruleTimeoutFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeoutFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeoutFunction"


    // $ANTLR start "ruleTimeoutFunction"
    // InternalReflex.g:927:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleBody ) ) ) ;
    public final EObject ruleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_time_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:933:2: ( (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleBody ) ) ) )
            // InternalReflex.g:934:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleBody ) ) )
            {
            // InternalReflex.g:934:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleBody ) ) )
            // InternalReflex.g:935:3: otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleBody ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimeoutFunctionAccess().getTimeoutKeyword_0());
              		
            }
            // InternalReflex.g:939:3: ( (lv_time_1_0= ruleTime ) )
            // InternalReflex.g:940:4: (lv_time_1_0= ruleTime )
            {
            // InternalReflex.g:940:4: (lv_time_1_0= ruleTime )
            // InternalReflex.g:941:5: lv_time_1_0= ruleTime
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeTimeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_time_1_0=ruleTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"time",
              						lv_time_1_0,
              						"ru.iaie.reflex.Reflex.Time");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:958:3: ( (lv_body_2_0= ruleBody ) )
            // InternalReflex.g:959:4: (lv_body_2_0= ruleBody )
            {
            // InternalReflex.g:959:4: (lv_body_2_0= ruleBody )
            // InternalReflex.g:960:5: lv_body_2_0= ruleBody
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getBodyBodyParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_2_0=ruleBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"ru.iaie.reflex.Reflex.Body");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeoutFunction"


    // $ANTLR start "entryRuleBody"
    // InternalReflex.g:981:1: entryRuleBody returns [EObject current=null] : iv_ruleBody= ruleBody EOF ;
    public final EObject entryRuleBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBody = null;


        try {
            // InternalReflex.g:981:45: (iv_ruleBody= ruleBody EOF )
            // InternalReflex.g:982:2: iv_ruleBody= ruleBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBodyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBody=ruleBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBody; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBody"


    // $ANTLR start "ruleBody"
    // InternalReflex.g:988:1: ruleBody returns [EObject current=null] : ( ( () otherlv_1= ';' ) | (otherlv_2= '{' ( (lv_sub_3_0= ruleBody ) )* otherlv_4= '}' ) | this_AssignStat_5= ruleAssignStat | this_IfElseStat_6= ruleIfElseStat | this_SwitchStat_7= ruleSwitchStat | this_StartProcStat_8= ruleStartProcStat | this_StopProcStat_9= ruleStopProcStat | this_ErrorStat_10= ruleErrorStat | ( () ruleLoopStat ) | ( () ruleRestartStat ) | this_SetStateStat_15= ruleSetStateStat ) ;
    public final EObject ruleBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_sub_3_0 = null;

        EObject this_AssignStat_5 = null;

        EObject this_IfElseStat_6 = null;

        EObject this_SwitchStat_7 = null;

        EObject this_StartProcStat_8 = null;

        EObject this_StopProcStat_9 = null;

        EObject this_ErrorStat_10 = null;

        EObject this_SetStateStat_15 = null;



        	enterRule();

        try {
            // InternalReflex.g:994:2: ( ( ( () otherlv_1= ';' ) | (otherlv_2= '{' ( (lv_sub_3_0= ruleBody ) )* otherlv_4= '}' ) | this_AssignStat_5= ruleAssignStat | this_IfElseStat_6= ruleIfElseStat | this_SwitchStat_7= ruleSwitchStat | this_StartProcStat_8= ruleStartProcStat | this_StopProcStat_9= ruleStopProcStat | this_ErrorStat_10= ruleErrorStat | ( () ruleLoopStat ) | ( () ruleRestartStat ) | this_SetStateStat_15= ruleSetStateStat ) )
            // InternalReflex.g:995:2: ( ( () otherlv_1= ';' ) | (otherlv_2= '{' ( (lv_sub_3_0= ruleBody ) )* otherlv_4= '}' ) | this_AssignStat_5= ruleAssignStat | this_IfElseStat_6= ruleIfElseStat | this_SwitchStat_7= ruleSwitchStat | this_StartProcStat_8= ruleStartProcStat | this_StopProcStat_9= ruleStopProcStat | this_ErrorStat_10= ruleErrorStat | ( () ruleLoopStat ) | ( () ruleRestartStat ) | this_SetStateStat_15= ruleSetStateStat )
            {
            // InternalReflex.g:995:2: ( ( () otherlv_1= ';' ) | (otherlv_2= '{' ( (lv_sub_3_0= ruleBody ) )* otherlv_4= '}' ) | this_AssignStat_5= ruleAssignStat | this_IfElseStat_6= ruleIfElseStat | this_SwitchStat_7= ruleSwitchStat | this_StartProcStat_8= ruleStartProcStat | this_StopProcStat_9= ruleStopProcStat | this_ErrorStat_10= ruleErrorStat | ( () ruleLoopStat ) | ( () ruleRestartStat ) | this_SetStateStat_15= ruleSetStateStat )
            int alt14=11;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt14=1;
                }
                break;
            case 33:
                {
                alt14=2;
                }
                break;
            case RULE_ID:
                {
                alt14=3;
                }
                break;
            case 47:
                {
                alt14=4;
                }
                break;
            case 51:
                {
                alt14=5;
                }
                break;
            case 55:
                {
                alt14=6;
                }
                break;
            case 56:
                {
                alt14=7;
                }
                break;
            case 57:
                {
                alt14=8;
                }
                break;
            case 58:
                {
                alt14=9;
                }
                break;
            case 59:
                {
                alt14=10;
                }
                break;
            case 60:
                {
                alt14=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalReflex.g:996:3: ( () otherlv_1= ';' )
                    {
                    // InternalReflex.g:996:3: ( () otherlv_1= ';' )
                    // InternalReflex.g:997:4: () otherlv_1= ';'
                    {
                    // InternalReflex.g:997:4: ()
                    // InternalReflex.g:998:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBodyAccess().getBodyAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getBodyAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1010:3: (otherlv_2= '{' ( (lv_sub_3_0= ruleBody ) )* otherlv_4= '}' )
                    {
                    // InternalReflex.g:1010:3: (otherlv_2= '{' ( (lv_sub_3_0= ruleBody ) )* otherlv_4= '}' )
                    // InternalReflex.g:1011:4: otherlv_2= '{' ( (lv_sub_3_0= ruleBody ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBodyAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:1015:4: ( (lv_sub_3_0= ruleBody ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID||LA13_0==33||LA13_0==36||LA13_0==47||LA13_0==51||(LA13_0>=55 && LA13_0<=60)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalReflex.g:1016:5: (lv_sub_3_0= ruleBody )
                    	    {
                    	    // InternalReflex.g:1016:5: (lv_sub_3_0= ruleBody )
                    	    // InternalReflex.g:1017:6: lv_sub_3_0= ruleBody
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getBodyAccess().getSubBodyParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_23);
                    	    lv_sub_3_0=ruleBody();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getBodyRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"sub",
                    	      							lv_sub_3_0,
                    	      							"ru.iaie.reflex.Reflex.Body");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBodyAccess().getRightCurlyBracketKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:1040:3: this_AssignStat_5= ruleAssignStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBodyAccess().getAssignStatParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AssignStat_5=ruleAssignStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignStat_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:1049:3: this_IfElseStat_6= ruleIfElseStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBodyAccess().getIfElseStatParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfElseStat_6=ruleIfElseStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfElseStat_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:1058:3: this_SwitchStat_7= ruleSwitchStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBodyAccess().getSwitchStatParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStat_7=ruleSwitchStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStat_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalReflex.g:1067:3: this_StartProcStat_8= ruleStartProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBodyAccess().getStartProcStatParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StartProcStat_8=ruleStartProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StartProcStat_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalReflex.g:1076:3: this_StopProcStat_9= ruleStopProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBodyAccess().getStopProcStatParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StopProcStat_9=ruleStopProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StopProcStat_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalReflex.g:1085:3: this_ErrorStat_10= ruleErrorStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBodyAccess().getErrorStatParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ErrorStat_10=ruleErrorStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ErrorStat_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalReflex.g:1094:3: ( () ruleLoopStat )
                    {
                    // InternalReflex.g:1094:3: ( () ruleLoopStat )
                    // InternalReflex.g:1095:4: () ruleLoopStat
                    {
                    // InternalReflex.g:1095:4: ()
                    // InternalReflex.g:1096:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBodyAccess().getBodyAction_8_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBodyAccess().getLoopStatParserRuleCall_8_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleLoopStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:1111:3: ( () ruleRestartStat )
                    {
                    // InternalReflex.g:1111:3: ( () ruleRestartStat )
                    // InternalReflex.g:1112:4: () ruleRestartStat
                    {
                    // InternalReflex.g:1112:4: ()
                    // InternalReflex.g:1113:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getBodyAccess().getBodyAction_9_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBodyAccess().getRestartStatParserRuleCall_9_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleRestartStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalReflex.g:1128:3: this_SetStateStat_15= ruleSetStateStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBodyAccess().getSetStateStatParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetStateStat_15=ruleSetStateStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetStateStat_15;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBody"


    // $ANTLR start "entryRuleAssignStat"
    // InternalReflex.g:1140:1: entryRuleAssignStat returns [EObject current=null] : iv_ruleAssignStat= ruleAssignStat EOF ;
    public final EObject entryRuleAssignStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignStat = null;


        try {
            // InternalReflex.g:1140:51: (iv_ruleAssignStat= ruleAssignStat EOF )
            // InternalReflex.g:1141:2: iv_ruleAssignStat= ruleAssignStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignStat=ruleAssignStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignStat"


    // $ANTLR start "ruleAssignStat"
    // InternalReflex.g:1147:1: ruleAssignStat returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignStat() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1153:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // InternalReflex.g:1154:2: ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:1154:2: ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            // InternalReflex.g:1155:3: ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            // InternalReflex.g:1155:3: ( (lv_varId_0_0= RULE_ID ) )
            // InternalReflex.g:1156:4: (lv_varId_0_0= RULE_ID )
            {
            // InternalReflex.g:1156:4: (lv_varId_0_0= RULE_ID )
            // InternalReflex.g:1157:5: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varId_0_0, grammarAccess.getAssignStatAccess().getVarIdIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssignStatRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varId",
              						lv_varId_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssignStatAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalReflex.g:1177:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:1178:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:1178:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:1179:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignStatAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignStatRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAssignStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignStat"


    // $ANTLR start "entryRuleIfElseStat"
    // InternalReflex.g:1204:1: entryRuleIfElseStat returns [EObject current=null] : iv_ruleIfElseStat= ruleIfElseStat EOF ;
    public final EObject entryRuleIfElseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseStat = null;


        try {
            // InternalReflex.g:1204:51: (iv_ruleIfElseStat= ruleIfElseStat EOF )
            // InternalReflex.g:1205:2: iv_ruleIfElseStat= ruleIfElseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfElseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfElseStat=ruleIfElseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfElseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfElseStat"


    // $ANTLR start "ruleIfElseStat"
    // InternalReflex.g:1211:1: ruleIfElseStat returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleCondition ) ) otherlv_3= ')' ( (lv_then_4_0= ruleBody ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleBody ) ) )? ) ;
    public final EObject ruleIfElseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_cond_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1217:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleCondition ) ) otherlv_3= ')' ( (lv_then_4_0= ruleBody ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleBody ) ) )? ) )
            // InternalReflex.g:1218:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleCondition ) ) otherlv_3= ')' ( (lv_then_4_0= ruleBody ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleBody ) ) )? )
            {
            // InternalReflex.g:1218:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleCondition ) ) otherlv_3= ')' ( (lv_then_4_0= ruleBody ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleBody ) ) )? )
            // InternalReflex.g:1219:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleCondition ) ) otherlv_3= ')' ( (lv_then_4_0= ruleBody ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleBody ) ) )?
            {
            otherlv_0=(Token)match(input,47,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,48,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfElseStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1227:3: ( (lv_cond_2_0= ruleCondition ) )
            // InternalReflex.g:1228:4: (lv_cond_2_0= ruleCondition )
            {
            // InternalReflex.g:1228:4: (lv_cond_2_0= ruleCondition )
            // InternalReflex.g:1229:5: lv_cond_2_0= ruleCondition
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getCondConditionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_cond_2_0=ruleCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"ru.iaie.reflex.Reflex.Condition");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,49,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfElseStatAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalReflex.g:1250:3: ( (lv_then_4_0= ruleBody ) )
            // InternalReflex.g:1251:4: (lv_then_4_0= ruleBody )
            {
            // InternalReflex.g:1251:4: (lv_then_4_0= ruleBody )
            // InternalReflex.g:1252:5: lv_then_4_0= ruleBody
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getThenBodyParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_then_4_0=ruleBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"ru.iaie.reflex.Reflex.Body");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1269:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleBody ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==50) ) {
                int LA15_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:1270:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleBody ) )
                    {
                    // InternalReflex.g:1270:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:1271:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,50,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfElseStatAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalReflex.g:1277:4: ( (lv_else_6_0= ruleBody ) )
                    // InternalReflex.g:1278:5: (lv_else_6_0= ruleBody )
                    {
                    // InternalReflex.g:1278:5: (lv_else_6_0= ruleBody )
                    // InternalReflex.g:1279:6: lv_else_6_0= ruleBody
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfElseStatAccess().getElseBodyParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_6_0=ruleBody();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfElseStatRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"ru.iaie.reflex.Reflex.Body");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfElseStat"


    // $ANTLR start "entryRuleSwitchStat"
    // InternalReflex.g:1301:1: entryRuleSwitchStat returns [EObject current=null] : iv_ruleSwitchStat= ruleSwitchStat EOF ;
    public final EObject entryRuleSwitchStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStat = null;


        try {
            // InternalReflex.g:1301:51: (iv_ruleSwitchStat= ruleSwitchStat EOF )
            // InternalReflex.g:1302:2: iv_ruleSwitchStat= ruleSwitchStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchStat=ruleSwitchStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStat"


    // $ANTLR start "ruleSwitchStat"
    // InternalReflex.g:1308:1: ruleSwitchStat returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) ;
    public final EObject ruleSwitchStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expr_2_0 = null;

        EObject lv_options_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1314:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) )
            // InternalReflex.g:1315:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:1315:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            // InternalReflex.g:1316:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,48,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1324:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:1325:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:1325:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:1326:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,49,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,33,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:1351:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==52) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalReflex.g:1352:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:1352:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:1353:5: lv_options_5_0= ruleCaseStat
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatAccess().getOptionsCaseStatParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_options_5_0=ruleCaseStat();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
            	      					}
            	      					add(
            	      						current,
            	      						"options",
            	      						lv_options_5_0,
            	      						"ru.iaie.reflex.Reflex.CaseStat");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_6=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSwitchStatAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStat"


    // $ANTLR start "entryRuleCaseStat"
    // InternalReflex.g:1378:1: entryRuleCaseStat returns [EObject current=null] : iv_ruleCaseStat= ruleCaseStat EOF ;
    public final EObject entryRuleCaseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStat = null;


        try {
            // InternalReflex.g:1378:49: (iv_ruleCaseStat= ruleCaseStat EOF )
            // InternalReflex.g:1379:2: iv_ruleCaseStat= ruleCaseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCaseStat=ruleCaseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseStat"


    // $ANTLR start "ruleCaseStat"
    // InternalReflex.g:1385:1: ruleCaseStat returns [EObject current=null] : (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleBody ) ) (otherlv_4= 'break' otherlv_5= ';' ) ) ;
    public final EObject ruleCaseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_option_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1391:2: ( (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleBody ) ) (otherlv_4= 'break' otherlv_5= ';' ) ) )
            // InternalReflex.g:1392:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleBody ) ) (otherlv_4= 'break' otherlv_5= ';' ) )
            {
            // InternalReflex.g:1392:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleBody ) ) (otherlv_4= 'break' otherlv_5= ';' ) )
            // InternalReflex.g:1393:3: otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleBody ) ) (otherlv_4= 'break' otherlv_5= ';' )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseStatAccess().getCaseKeyword_0());
              		
            }
            // InternalReflex.g:1397:3: ( (lv_option_1_0= ruleInteger ) )
            // InternalReflex.g:1398:4: (lv_option_1_0= ruleInteger )
            {
            // InternalReflex.g:1398:4: (lv_option_1_0= ruleInteger )
            // InternalReflex.g:1399:5: lv_option_1_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getOptionIntegerParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_29);
            lv_option_1_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"option",
              						lv_option_1_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,53,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCaseStatAccess().getColonKeyword_2());
              		
            }
            // InternalReflex.g:1420:3: ( (lv_body_3_0= ruleBody ) )
            // InternalReflex.g:1421:4: (lv_body_3_0= ruleBody )
            {
            // InternalReflex.g:1421:4: (lv_body_3_0= ruleBody )
            // InternalReflex.g:1422:5: lv_body_3_0= ruleBody
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getBodyBodyParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_body_3_0=ruleBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_3_0,
              						"ru.iaie.reflex.Reflex.Body");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1439:3: (otherlv_4= 'break' otherlv_5= ';' )
            // InternalReflex.g:1440:4: otherlv_4= 'break' otherlv_5= ';'
            {
            otherlv_4=(Token)match(input,54,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getCaseStatAccess().getBreakKeyword_4_0());
              			
            }
            otherlv_5=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getCaseStatAccess().getSemicolonKeyword_4_1());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseStat"


    // $ANTLR start "entryRuleStartProcStat"
    // InternalReflex.g:1453:1: entryRuleStartProcStat returns [EObject current=null] : iv_ruleStartProcStat= ruleStartProcStat EOF ;
    public final EObject entryRuleStartProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcStat = null;


        try {
            // InternalReflex.g:1453:54: (iv_ruleStartProcStat= ruleStartProcStat EOF )
            // InternalReflex.g:1454:2: iv_ruleStartProcStat= ruleStartProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStartProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStartProcStat=ruleStartProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStartProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartProcStat"


    // $ANTLR start "ruleStartProcStat"
    // InternalReflex.g:1460:1: ruleStartProcStat returns [EObject current=null] : (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleStartProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_procId_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1466:2: ( (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalReflex.g:1467:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:1467:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalReflex.g:1468:3: otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStartProcStatAccess().getStartKeyword_0());
              		
            }
            // InternalReflex.g:1472:3: ( (lv_procId_1_0= RULE_ID ) )
            // InternalReflex.g:1473:4: (lv_procId_1_0= RULE_ID )
            {
            // InternalReflex.g:1473:4: (lv_procId_1_0= RULE_ID )
            // InternalReflex.g:1474:5: lv_procId_1_0= RULE_ID
            {
            lv_procId_1_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_procId_1_0, grammarAccess.getStartProcStatAccess().getProcIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStartProcStatRule());
              					}
              					setWithLastConsumed(
              						current,
              						"procId",
              						lv_procId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStartProcStatAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartProcStat"


    // $ANTLR start "entryRuleStopProcStat"
    // InternalReflex.g:1498:1: entryRuleStopProcStat returns [EObject current=null] : iv_ruleStopProcStat= ruleStopProcStat EOF ;
    public final EObject entryRuleStopProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcStat = null;


        try {
            // InternalReflex.g:1498:53: (iv_ruleStopProcStat= ruleStopProcStat EOF )
            // InternalReflex.g:1499:2: iv_ruleStopProcStat= ruleStopProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStopProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStopProcStat=ruleStopProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStopProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStopProcStat"


    // $ANTLR start "ruleStopProcStat"
    // InternalReflex.g:1505:1: ruleStopProcStat returns [EObject current=null] : ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleStopProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1511:2: ( ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1512:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1512:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1513:3: () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1513:3: ()
            // InternalReflex.g:1514:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStopProcStatAccess().getStopProcStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:1524:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalReflex.g:1525:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1525:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1526:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_procId_2_0, grammarAccess.getStopProcStatAccess().getProcIdIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getStopProcStatRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"procId",
                      						true,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStopProcStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopProcStat"


    // $ANTLR start "entryRuleErrorStat"
    // InternalReflex.g:1550:1: entryRuleErrorStat returns [EObject current=null] : iv_ruleErrorStat= ruleErrorStat EOF ;
    public final EObject entryRuleErrorStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorStat = null;


        try {
            // InternalReflex.g:1550:50: (iv_ruleErrorStat= ruleErrorStat EOF )
            // InternalReflex.g:1551:2: iv_ruleErrorStat= ruleErrorStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorStat=ruleErrorStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorStat"


    // $ANTLR start "ruleErrorStat"
    // InternalReflex.g:1557:1: ruleErrorStat returns [EObject current=null] : ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleErrorStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1563:2: ( ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1564:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1564:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1565:3: () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1565:3: ()
            // InternalReflex.g:1566:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getErrorStatAccess().getErrorStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:1576:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalReflex.g:1577:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1577:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1578:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_procId_2_0, grammarAccess.getErrorStatAccess().getProcIdIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getErrorStatRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"procId",
                      						true,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getErrorStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorStat"


    // $ANTLR start "entryRuleLoopStat"
    // InternalReflex.g:1602:1: entryRuleLoopStat returns [String current=null] : iv_ruleLoopStat= ruleLoopStat EOF ;
    public final String entryRuleLoopStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLoopStat = null;


        try {
            // InternalReflex.g:1602:48: (iv_ruleLoopStat= ruleLoopStat EOF )
            // InternalReflex.g:1603:2: iv_ruleLoopStat= ruleLoopStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopStat=ruleLoopStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopStat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopStat"


    // $ANTLR start "ruleLoopStat"
    // InternalReflex.g:1609:1: ruleLoopStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'loop' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleLoopStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:1615:2: ( (kw= 'loop' kw= ';' ) )
            // InternalReflex.g:1616:2: (kw= 'loop' kw= ';' )
            {
            // InternalReflex.g:1616:2: (kw= 'loop' kw= ';' )
            // InternalReflex.g:1617:3: kw= 'loop' kw= ';'
            {
            kw=(Token)match(input,58,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getLoopStatAccess().getLoopKeyword_0());
              		
            }
            kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getLoopStatAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopStat"


    // $ANTLR start "entryRuleRestartStat"
    // InternalReflex.g:1631:1: entryRuleRestartStat returns [String current=null] : iv_ruleRestartStat= ruleRestartStat EOF ;
    public final String entryRuleRestartStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRestartStat = null;


        try {
            // InternalReflex.g:1631:51: (iv_ruleRestartStat= ruleRestartStat EOF )
            // InternalReflex.g:1632:2: iv_ruleRestartStat= ruleRestartStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRestartStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRestartStat=ruleRestartStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRestartStat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestartStat"


    // $ANTLR start "ruleRestartStat"
    // InternalReflex.g:1638:1: ruleRestartStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'restart' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleRestartStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:1644:2: ( (kw= 'restart' kw= ';' ) )
            // InternalReflex.g:1645:2: (kw= 'restart' kw= ';' )
            {
            // InternalReflex.g:1645:2: (kw= 'restart' kw= ';' )
            // InternalReflex.g:1646:3: kw= 'restart' kw= ';'
            {
            kw=(Token)match(input,59,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRestartStatAccess().getRestartKeyword_0());
              		
            }
            kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRestartStatAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestartStat"


    // $ANTLR start "entryRuleSetStateStat"
    // InternalReflex.g:1660:1: entryRuleSetStateStat returns [EObject current=null] : iv_ruleSetStateStat= ruleSetStateStat EOF ;
    public final EObject entryRuleSetStateStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStat = null;


        try {
            // InternalReflex.g:1660:53: (iv_ruleSetStateStat= ruleSetStateStat EOF )
            // InternalReflex.g:1661:2: iv_ruleSetStateStat= ruleSetStateStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetStateStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetStateStat=ruleSetStateStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetStateStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetStateStat"


    // $ANTLR start "ruleSetStateStat"
    // InternalReflex.g:1667:1: ruleSetStateStat returns [EObject current=null] : ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | otherlv_4= 'next' ) otherlv_5= ';' ) ;
    public final EObject ruleSetStateStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_stateId_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalReflex.g:1673:2: ( ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | otherlv_4= 'next' ) otherlv_5= ';' ) )
            // InternalReflex.g:1674:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | otherlv_4= 'next' ) otherlv_5= ';' )
            {
            // InternalReflex.g:1674:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | otherlv_4= 'next' ) otherlv_5= ';' )
            // InternalReflex.g:1675:3: () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | otherlv_4= 'next' ) otherlv_5= ';'
            {
            // InternalReflex.g:1675:3: ()
            // InternalReflex.g:1676:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetStateStatAccess().getSetStateStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,60,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:1686:3: ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | otherlv_4= 'next' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==45) ) {
                alt19=1;
            }
            else if ( (LA19_0==61) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalReflex.g:1687:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    {
                    // InternalReflex.g:1687:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    // InternalReflex.g:1688:5: otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getSetStateStatAccess().getStateKeyword_2_0_0());
                      				
                    }
                    // InternalReflex.g:1692:5: ( (lv_stateId_3_0= RULE_ID ) )
                    // InternalReflex.g:1693:6: (lv_stateId_3_0= RULE_ID )
                    {
                    // InternalReflex.g:1693:6: (lv_stateId_3_0= RULE_ID )
                    // InternalReflex.g:1694:7: lv_stateId_3_0= RULE_ID
                    {
                    lv_stateId_3_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_stateId_3_0, grammarAccess.getSetStateStatAccess().getStateIdIDTerminalRuleCall_2_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSetStateStatRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"stateId",
                      								lv_stateId_3_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1712:4: otherlv_4= 'next'
                    {
                    otherlv_4=(Token)match(input,61,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getSetStateStatAccess().getNextKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getSetStateStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetStateStat"


    // $ANTLR start "entryRuleFunction"
    // InternalReflex.g:1725:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalReflex.g:1725:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalReflex.g:1726:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalReflex.g:1732:1: ruleFunction returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_returnType_0_0 = null;

        EObject lv_argTypes_3_0 = null;

        EObject lv_argTypes_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1738:2: ( ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // InternalReflex.g:1739:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // InternalReflex.g:1739:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // InternalReflex.g:1740:3: ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // InternalReflex.g:1740:3: ( (lv_returnType_0_0= ruleCType ) )
            // InternalReflex.g:1741:4: (lv_returnType_0_0= ruleCType )
            {
            // InternalReflex.g:1741:4: (lv_returnType_0_0= ruleCType )
            // InternalReflex.g:1742:5: lv_returnType_0_0= ruleCType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeCTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_returnType_0_0=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_0_0,
              						"ru.iaie.reflex.Reflex.CType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1759:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1760:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1760:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1761:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,48,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalReflex.g:1781:3: ( (lv_argTypes_3_0= ruleCType ) )
            // InternalReflex.g:1782:4: (lv_argTypes_3_0= ruleCType )
            {
            // InternalReflex.g:1782:4: (lv_argTypes_3_0= ruleCType )
            // InternalReflex.g:1783:5: lv_argTypes_3_0= ruleCType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesCTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_argTypes_3_0=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					add(
              						current,
              						"argTypes",
              						lv_argTypes_3_0,
              						"ru.iaie.reflex.Reflex.CType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1800:3: (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==39) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalReflex.g:1801:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) )
            	    {
            	    otherlv_4=(Token)match(input,39,FOLLOW_33); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1805:4: ( (lv_argTypes_5_0= ruleCType ) )
            	    // InternalReflex.g:1806:5: (lv_argTypes_5_0= ruleCType )
            	    {
            	    // InternalReflex.g:1806:5: (lv_argTypes_5_0= ruleCType )
            	    // InternalReflex.g:1807:6: lv_argTypes_5_0= ruleCType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesCTypeParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_argTypes_5_0=ruleCType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"argTypes",
            	      							lv_argTypes_5_0,
            	      							"ru.iaie.reflex.Reflex.CType");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_6=(Token)match(input,49,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleRegister"
    // InternalReflex.g:1837:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // InternalReflex.g:1837:49: (iv_ruleRegister= ruleRegister EOF )
            // InternalReflex.g:1838:2: iv_ruleRegister= ruleRegister EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegister=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegister; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // InternalReflex.g:1844:1: ruleRegister returns [EObject current=null] : ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_regSize_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_addr1_2_0 = null;

        EObject lv_addr2_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1850:2: ( ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1851:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1851:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' )
            // InternalReflex.g:1852:3: ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1852:3: ( (lv_type_0_0= ruleRegisterType ) )
            // InternalReflex.g:1853:4: (lv_type_0_0= ruleRegisterType )
            {
            // InternalReflex.g:1853:4: (lv_type_0_0= ruleRegisterType )
            // InternalReflex.g:1854:5: lv_type_0_0= ruleRegisterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getTypeRegisterTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleRegisterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.RegisterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1871:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1872:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1872:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1873:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRegisterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:1889:3: ( (lv_addr1_2_0= ruleInteger ) )
            // InternalReflex.g:1890:4: (lv_addr1_2_0= ruleInteger )
            {
            // InternalReflex.g:1890:4: (lv_addr1_2_0= ruleInteger )
            // InternalReflex.g:1891:5: lv_addr1_2_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getAddr1IntegerParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_addr1_2_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"addr1",
              						lv_addr1_2_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1908:3: ( (lv_addr2_3_0= ruleInteger ) )
            // InternalReflex.g:1909:4: (lv_addr2_3_0= ruleInteger )
            {
            // InternalReflex.g:1909:4: (lv_addr2_3_0= ruleInteger )
            // InternalReflex.g:1910:5: lv_addr2_3_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getAddr2IntegerParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_addr2_3_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"addr2",
              						lv_addr2_3_0,
              						"ru.iaie.reflex.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1927:3: ( (lv_regSize_4_0= RULE_REG_SIZE ) )
            // InternalReflex.g:1928:4: (lv_regSize_4_0= RULE_REG_SIZE )
            {
            // InternalReflex.g:1928:4: (lv_regSize_4_0= RULE_REG_SIZE )
            // InternalReflex.g:1929:5: lv_regSize_4_0= RULE_REG_SIZE
            {
            lv_regSize_4_0=(Token)match(input,RULE_REG_SIZE,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regSize_4_0, grammarAccess.getRegisterAccess().getRegSizeREG_SIZETerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regSize",
              						lv_regSize_4_0,
              						"ru.iaie.reflex.Reflex.REG_SIZE");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRegisterAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleConst"
    // InternalReflex.g:1953:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:1953:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:1954:2: iv_ruleConst= ruleConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConst=ruleConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalReflex.g:1960:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constId_1_0=null;
        Token otherlv_3=null;
        EObject lv_constValue_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1966:2: ( (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // InternalReflex.g:1967:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:1967:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            // InternalReflex.g:1968:3: otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:1972:3: ( (lv_constId_1_0= RULE_ID ) )
            // InternalReflex.g:1973:4: (lv_constId_1_0= RULE_ID )
            {
            // InternalReflex.g:1973:4: (lv_constId_1_0= RULE_ID )
            // InternalReflex.g:1974:5: lv_constId_1_0= RULE_ID
            {
            lv_constId_1_0=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_constId_1_0, grammarAccess.getConstAccess().getConstIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstRule());
              					}
              					setWithLastConsumed(
              						current,
              						"constId",
              						lv_constId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:1990:3: ( (lv_constValue_2_0= ruleExpression ) )
            // InternalReflex.g:1991:4: (lv_constValue_2_0= ruleExpression )
            {
            // InternalReflex.g:1991:4: (lv_constValue_2_0= ruleExpression )
            // InternalReflex.g:1992:5: lv_constValue_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getConstValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_constValue_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"constValue",
              						lv_constValue_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleEnum"
    // InternalReflex.g:2017:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:2017:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:2018:2: iv_ruleEnum= ruleEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnum=ruleEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnum; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnum"


    // $ANTLR start "ruleEnum"
    // InternalReflex.g:2024:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_enumMembers_1_0 = null;

        EObject lv_enumMembers_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2030:2: ( (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' ) )
            // InternalReflex.g:2031:2: (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' )
            {
            // InternalReflex.g:2031:2: (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' )
            // InternalReflex.g:2032:3: otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:2036:3: ( (lv_enumMembers_1_0= ruleEnumMember ) )
            // InternalReflex.g:2037:4: (lv_enumMembers_1_0= ruleEnumMember )
            {
            // InternalReflex.g:2037:4: (lv_enumMembers_1_0= ruleEnumMember )
            // InternalReflex.g:2038:5: lv_enumMembers_1_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_enumMembers_1_0=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumRule());
              					}
              					add(
              						current,
              						"enumMembers",
              						lv_enumMembers_1_0,
              						"ru.iaie.reflex.Reflex.EnumMember");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2055:3: (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==39) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:2056:4: otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) )
            	    {
            	    otherlv_2=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalReflex.g:2060:4: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            	    // InternalReflex.g:2061:5: (lv_enumMembers_3_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:2061:5: (lv_enumMembers_3_0= ruleEnumMember )
            	    // InternalReflex.g:2062:6: lv_enumMembers_3_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_enumMembers_3_0=ruleEnumMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumMembers",
            	      							lv_enumMembers_3_0,
            	      							"ru.iaie.reflex.Reflex.EnumMember");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnum"


    // $ANTLR start "entryRuleEnumMember"
    // InternalReflex.g:2088:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:2088:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:2089:2: iv_ruleEnumMember= ruleEnumMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumMember=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumMember"


    // $ANTLR start "ruleEnumMember"
    // InternalReflex.g:2095:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2101:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalReflex.g:2102:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalReflex.g:2102:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalReflex.g:2103:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalReflex.g:2103:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:2104:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:2104:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:2105:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getEnumMemberAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumMemberRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalReflex.g:2125:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalReflex.g:2126:4: (lv_value_2_0= ruleExpression )
            {
            // InternalReflex.g:2126:4: (lv_value_2_0= ruleExpression )
            // InternalReflex.g:2127:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumMemberAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumMemberRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumMember"


    // $ANTLR start "entryRuleExpression"
    // InternalReflex.g:2148:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:2148:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:2149:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalReflex.g:2155:1: ruleExpression returns [EObject current=null] : (this_Integer_0= ruleInteger | this_ID_1= RULE_ID ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token this_ID_1=null;
        EObject this_Integer_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2161:2: ( (this_Integer_0= ruleInteger | this_ID_1= RULE_ID ) )
            // InternalReflex.g:2162:2: (this_Integer_0= ruleInteger | this_ID_1= RULE_ID )
            {
            // InternalReflex.g:2162:2: (this_Integer_0= ruleInteger | this_ID_1= RULE_ID )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_DECIMAL && LA22_0<=RULE_HEX)) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_ID) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalReflex.g:2163:3: this_Integer_0= ruleInteger
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getIntegerParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Integer_0=ruleInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Integer_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2172:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getExpressionAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleCondition"
    // InternalReflex.g:2180:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalReflex.g:2180:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalReflex.g:2181:2: iv_ruleCondition= ruleCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalReflex.g:2187:1: ruleCondition returns [EObject current=null] : (this_Integer_0= ruleInteger | this_ID_1= RULE_ID ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token this_ID_1=null;
        EObject this_Integer_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2193:2: ( (this_Integer_0= ruleInteger | this_ID_1= RULE_ID ) )
            // InternalReflex.g:2194:2: (this_Integer_0= ruleInteger | this_ID_1= RULE_ID )
            {
            // InternalReflex.g:2194:2: (this_Integer_0= ruleInteger | this_ID_1= RULE_ID )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_DECIMAL && LA23_0<=RULE_HEX)) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_ID) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalReflex.g:2195:3: this_Integer_0= ruleInteger
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConditionAccess().getIntegerParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Integer_0=ruleInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Integer_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2204:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getConditionAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleCType"
    // InternalReflex.g:2212:1: entryRuleCType returns [EObject current=null] : iv_ruleCType= ruleCType EOF ;
    public final EObject entryRuleCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCType = null;


        try {
            // InternalReflex.g:2212:46: (iv_ruleCType= ruleCType EOF )
            // InternalReflex.g:2213:2: iv_ruleCType= ruleCType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCType=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCType"


    // $ANTLR start "ruleCType"
    // InternalReflex.g:2219:1: ruleCType returns [EObject current=null] : ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) ;
    public final EObject ruleCType() throws RecognitionException {
        EObject current = null;

        Token this_VOID_C_TYPE_1=null;
        Token this_FLOAT_C_TYPE_3=null;
        Token this_DOUBLE_C_TYPE_5=null;
        Token this_SHORT_C_TYPE_8=null;
        Token this_INT_C_TYPE_9=null;
        Token this_LONG_C_TYPE_10=null;
        Enumerator lv_signSpec_7_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2225:2: ( ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) )
            // InternalReflex.g:2226:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            {
            // InternalReflex.g:2226:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case RULE_VOID_C_TYPE:
                {
                alt26=1;
                }
                break;
            case RULE_FLOAT_C_TYPE:
                {
                alt26=2;
                }
                break;
            case RULE_DOUBLE_C_TYPE:
                {
                alt26=3;
                }
                break;
            case RULE_SHORT_C_TYPE:
            case RULE_INT_C_TYPE:
            case RULE_LONG_C_TYPE:
            case 68:
            case 69:
                {
                alt26=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalReflex.g:2227:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    {
                    // InternalReflex.g:2227:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    // InternalReflex.g:2228:4: () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE
                    {
                    // InternalReflex.g:2228:4: ()
                    // InternalReflex.g:2229:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    this_VOID_C_TYPE_1=(Token)match(input,RULE_VOID_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_VOID_C_TYPE_1, grammarAccess.getCTypeAccess().getVOID_C_TYPETerminalRuleCall_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2241:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    {
                    // InternalReflex.g:2241:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    // InternalReflex.g:2242:4: () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE
                    {
                    // InternalReflex.g:2242:4: ()
                    // InternalReflex.g:2243:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_FLOAT_C_TYPE_3=(Token)match(input,RULE_FLOAT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FLOAT_C_TYPE_3, grammarAccess.getCTypeAccess().getFLOAT_C_TYPETerminalRuleCall_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:2255:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    {
                    // InternalReflex.g:2255:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    // InternalReflex.g:2256:4: () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE
                    {
                    // InternalReflex.g:2256:4: ()
                    // InternalReflex.g:2257:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_2_0(),
                      						current);
                      				
                    }

                    }

                    this_DOUBLE_C_TYPE_5=(Token)match(input,RULE_DOUBLE_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DOUBLE_C_TYPE_5, grammarAccess.getCTypeAccess().getDOUBLE_C_TYPETerminalRuleCall_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:2269:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    {
                    // InternalReflex.g:2269:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    // InternalReflex.g:2270:4: () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    {
                    // InternalReflex.g:2270:4: ()
                    // InternalReflex.g:2271:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:2277:4: ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( ((LA24_0>=68 && LA24_0<=69)) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalReflex.g:2278:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            {
                            // InternalReflex.g:2278:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            // InternalReflex.g:2279:6: lv_signSpec_7_0= ruleCTypeSignSpec
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getCTypeAccess().getSignSpecCTypeSignSpecEnumRuleCall_3_1_0());
                              					
                            }
                            pushFollow(FOLLOW_37);
                            lv_signSpec_7_0=ruleCTypeSignSpec();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getCTypeRule());
                              						}
                              						set(
                              							current,
                              							"signSpec",
                              							true,
                              							"ru.iaie.reflex.Reflex.CTypeSignSpec");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalReflex.g:2296:4: (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    int alt25=3;
                    switch ( input.LA(1) ) {
                    case RULE_SHORT_C_TYPE:
                        {
                        alt25=1;
                        }
                        break;
                    case RULE_INT_C_TYPE:
                        {
                        alt25=2;
                        }
                        break;
                    case RULE_LONG_C_TYPE:
                        {
                        alt25=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }

                    switch (alt25) {
                        case 1 :
                            // InternalReflex.g:2297:5: this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE
                            {
                            this_SHORT_C_TYPE_8=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SHORT_C_TYPE_8, grammarAccess.getCTypeAccess().getSHORT_C_TYPETerminalRuleCall_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:2302:5: this_INT_C_TYPE_9= RULE_INT_C_TYPE
                            {
                            this_INT_C_TYPE_9=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_INT_C_TYPE_9, grammarAccess.getCTypeAccess().getINT_C_TYPETerminalRuleCall_3_2_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalReflex.g:2307:5: this_LONG_C_TYPE_10= RULE_LONG_C_TYPE
                            {
                            this_LONG_C_TYPE_10=(Token)match(input,RULE_LONG_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_LONG_C_TYPE_10, grammarAccess.getCTypeAccess().getLONG_C_TYPETerminalRuleCall_3_2_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCType"


    // $ANTLR start "entryRuleIntegerType"
    // InternalReflex.g:2317:1: entryRuleIntegerType returns [String current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final String entryRuleIntegerType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerType = null;


        try {
            // InternalReflex.g:2317:51: (iv_ruleIntegerType= ruleIntegerType EOF )
            // InternalReflex.g:2318:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // InternalReflex.g:2324:1: ruleIntegerType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) ;
    public final AntlrDatatypeRuleToken ruleIntegerType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_TYPE_0=null;
        Token this_INT_C_TYPE_1=null;
        Token this_SHORT_C_TYPE_2=null;
        Token this_LONG_C_TYPE_3=null;


        	enterRule();

        try {
            // InternalReflex.g:2330:2: ( (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) )
            // InternalReflex.g:2331:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            {
            // InternalReflex.g:2331:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            int alt27=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                alt27=1;
                }
                break;
            case RULE_INT_C_TYPE:
                {
                alt27=2;
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                alt27=3;
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                alt27=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalReflex.g:2332:3: this_BOOL_TYPE_0= RULE_BOOL_TYPE
                    {
                    this_BOOL_TYPE_0=(Token)match(input,RULE_BOOL_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_BOOL_TYPE_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_BOOL_TYPE_0, grammarAccess.getIntegerTypeAccess().getBOOL_TYPETerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2340:3: this_INT_C_TYPE_1= RULE_INT_C_TYPE
                    {
                    this_INT_C_TYPE_1=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_C_TYPE_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_C_TYPE_1, grammarAccess.getIntegerTypeAccess().getINT_C_TYPETerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:2348:3: this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE
                    {
                    this_SHORT_C_TYPE_2=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_SHORT_C_TYPE_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_SHORT_C_TYPE_2, grammarAccess.getIntegerTypeAccess().getSHORT_C_TYPETerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:2356:3: this_LONG_C_TYPE_3= RULE_LONG_C_TYPE
                    {
                    this_LONG_C_TYPE_3=(Token)match(input,RULE_LONG_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_LONG_C_TYPE_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_LONG_C_TYPE_3, grammarAccess.getIntegerTypeAccess().getLONG_C_TYPETerminalRuleCall_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleReflexType"
    // InternalReflex.g:2367:1: entryRuleReflexType returns [EObject current=null] : iv_ruleReflexType= ruleReflexType EOF ;
    public final EObject entryRuleReflexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReflexType = null;


        try {
            // InternalReflex.g:2367:51: (iv_ruleReflexType= ruleReflexType EOF )
            // InternalReflex.g:2368:2: iv_ruleReflexType= ruleReflexType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReflexTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReflexType=ruleReflexType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReflexType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReflexType"


    // $ANTLR start "ruleReflexType"
    // InternalReflex.g:2374:1: ruleReflexType returns [EObject current=null] : (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) ;
    public final EObject ruleReflexType() throws RecognitionException {
        EObject current = null;

        Token this_BOOL_TYPE_2=null;
        EObject this_CType_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2380:2: ( (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) )
            // InternalReflex.g:2381:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            {
            // InternalReflex.g:2381:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_VOID_C_TYPE && LA28_0<=RULE_LONG_C_TYPE)||(LA28_0>=68 && LA28_0<=69)) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_BOOL_TYPE) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalReflex.g:2382:3: this_CType_0= ruleCType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReflexTypeAccess().getCTypeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CType_0=ruleCType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CType_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2391:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    {
                    // InternalReflex.g:2391:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    // InternalReflex.g:2392:4: () this_BOOL_TYPE_2= RULE_BOOL_TYPE
                    {
                    // InternalReflex.g:2392:4: ()
                    // InternalReflex.g:2393:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getReflexTypeAccess().getReflexTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_BOOL_TYPE_2=(Token)match(input,RULE_BOOL_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BOOL_TYPE_2, grammarAccess.getReflexTypeAccess().getBOOL_TYPETerminalRuleCall_1_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReflexType"


    // $ANTLR start "entryRuleInteger"
    // InternalReflex.g:2408:1: entryRuleInteger returns [EObject current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final EObject entryRuleInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteger = null;


        try {
            // InternalReflex.g:2408:48: (iv_ruleInteger= ruleInteger EOF )
            // InternalReflex.g:2409:2: iv_ruleInteger= ruleInteger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInteger=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInteger; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // InternalReflex.g:2415:1: ruleInteger returns [EObject current=null] : ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) ;
    public final EObject ruleInteger() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_value_0_3=null;
        Token lv_qualfier_1_1=null;
        Token lv_qualfier_1_2=null;


        	enterRule();

        try {
            // InternalReflex.g:2421:2: ( ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) )
            // InternalReflex.g:2422:2: ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            {
            // InternalReflex.g:2422:2: ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            // InternalReflex.g:2423:3: ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            {
            // InternalReflex.g:2423:3: ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) )
            // InternalReflex.g:2424:4: ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) )
            {
            // InternalReflex.g:2424:4: ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) )
            // InternalReflex.g:2425:5: (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX )
            {
            // InternalReflex.g:2425:5: (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX )
            int alt29=3;
            switch ( input.LA(1) ) {
            case RULE_DECIMAL:
                {
                alt29=1;
                }
                break;
            case RULE_OCTAL:
                {
                alt29=2;
                }
                break;
            case RULE_HEX:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalReflex.g:2426:6: lv_value_0_1= RULE_DECIMAL
                    {
                    lv_value_0_1=(Token)match(input,RULE_DECIMAL,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_1, grammarAccess.getIntegerAccess().getValueDECIMALTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_1,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2441:6: lv_value_0_2= RULE_OCTAL
                    {
                    lv_value_0_2=(Token)match(input,RULE_OCTAL,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_2, grammarAccess.getIntegerAccess().getValueOCTALTerminalRuleCall_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_2,
                      							"ru.iaie.reflex.Reflex.OCTAL");
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:2456:6: lv_value_0_3= RULE_HEX
                    {
                    lv_value_0_3=(Token)match(input,RULE_HEX,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_3, grammarAccess.getIntegerAccess().getValueHEXTerminalRuleCall_0_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_3,
                      							"ru.iaie.reflex.Reflex.HEX");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalReflex.g:2473:3: ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_LONG && LA31_0<=RULE_UNSIGNED)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalReflex.g:2474:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    {
                    // InternalReflex.g:2474:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    // InternalReflex.g:2475:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    {
                    // InternalReflex.g:2475:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==RULE_LONG) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==RULE_UNSIGNED) ) {
                        alt30=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalReflex.g:2476:6: lv_qualfier_1_1= RULE_LONG
                            {
                            lv_qualfier_1_1=(Token)match(input,RULE_LONG,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_qualfier_1_1, grammarAccess.getIntegerAccess().getQualfierLONGTerminalRuleCall_1_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"qualfier",
                              							true,
                              							"ru.iaie.reflex.Reflex.LONG");
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:2491:6: lv_qualfier_1_2= RULE_UNSIGNED
                            {
                            lv_qualfier_1_2=(Token)match(input,RULE_UNSIGNED,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_qualfier_1_2, grammarAccess.getIntegerAccess().getQualfierUNSIGNEDTerminalRuleCall_1_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"qualfier",
                              							true,
                              							"ru.iaie.reflex.Reflex.UNSIGNED");
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleTime"
    // InternalReflex.g:2512:1: entryRuleTime returns [EObject current=null] : iv_ruleTime= ruleTime EOF ;
    public final EObject entryRuleTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTime = null;


        try {
            // InternalReflex.g:2512:45: (iv_ruleTime= ruleTime EOF )
            // InternalReflex.g:2513:2: iv_ruleTime= ruleTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTime=ruleTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTime; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTime"


    // $ANTLR start "ruleTime"
    // InternalReflex.g:2519:1: ruleTime returns [EObject current=null] : ( (otherlv_0= '0t' | otherlv_1= '0T' ) (this_DAY_2= RULE_DAY ( (lv_days_3_0= RULE_DECIMAL ) ) )? (this_HOUR_4= RULE_HOUR ( (lv_hours_5_0= RULE_DECIMAL ) ) )? (this_MINUTE_6= RULE_MINUTE ( (lv_minutes_7_0= RULE_DECIMAL ) ) )? (this_SECOND_8= RULE_SECOND ( (lv_seconds_9_0= RULE_DECIMAL ) ) )? (this_MILISECOND_10= RULE_MILISECOND ( (lv_milis_11_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_12= RULE_MICROSECOND ( (lv_micros_13_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_14= RULE_NANOSECOND ( (lv_nanos_15_0= RULE_DECIMAL ) ) )? ) ;
    public final EObject ruleTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_DAY_2=null;
        Token lv_days_3_0=null;
        Token this_HOUR_4=null;
        Token lv_hours_5_0=null;
        Token this_MINUTE_6=null;
        Token lv_minutes_7_0=null;
        Token this_SECOND_8=null;
        Token lv_seconds_9_0=null;
        Token this_MILISECOND_10=null;
        Token lv_milis_11_0=null;
        Token this_MICROSECOND_12=null;
        Token lv_micros_13_0=null;
        Token this_NANOSECOND_14=null;
        Token lv_nanos_15_0=null;


        	enterRule();

        try {
            // InternalReflex.g:2525:2: ( ( (otherlv_0= '0t' | otherlv_1= '0T' ) (this_DAY_2= RULE_DAY ( (lv_days_3_0= RULE_DECIMAL ) ) )? (this_HOUR_4= RULE_HOUR ( (lv_hours_5_0= RULE_DECIMAL ) ) )? (this_MINUTE_6= RULE_MINUTE ( (lv_minutes_7_0= RULE_DECIMAL ) ) )? (this_SECOND_8= RULE_SECOND ( (lv_seconds_9_0= RULE_DECIMAL ) ) )? (this_MILISECOND_10= RULE_MILISECOND ( (lv_milis_11_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_12= RULE_MICROSECOND ( (lv_micros_13_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_14= RULE_NANOSECOND ( (lv_nanos_15_0= RULE_DECIMAL ) ) )? ) )
            // InternalReflex.g:2526:2: ( (otherlv_0= '0t' | otherlv_1= '0T' ) (this_DAY_2= RULE_DAY ( (lv_days_3_0= RULE_DECIMAL ) ) )? (this_HOUR_4= RULE_HOUR ( (lv_hours_5_0= RULE_DECIMAL ) ) )? (this_MINUTE_6= RULE_MINUTE ( (lv_minutes_7_0= RULE_DECIMAL ) ) )? (this_SECOND_8= RULE_SECOND ( (lv_seconds_9_0= RULE_DECIMAL ) ) )? (this_MILISECOND_10= RULE_MILISECOND ( (lv_milis_11_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_12= RULE_MICROSECOND ( (lv_micros_13_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_14= RULE_NANOSECOND ( (lv_nanos_15_0= RULE_DECIMAL ) ) )? )
            {
            // InternalReflex.g:2526:2: ( (otherlv_0= '0t' | otherlv_1= '0T' ) (this_DAY_2= RULE_DAY ( (lv_days_3_0= RULE_DECIMAL ) ) )? (this_HOUR_4= RULE_HOUR ( (lv_hours_5_0= RULE_DECIMAL ) ) )? (this_MINUTE_6= RULE_MINUTE ( (lv_minutes_7_0= RULE_DECIMAL ) ) )? (this_SECOND_8= RULE_SECOND ( (lv_seconds_9_0= RULE_DECIMAL ) ) )? (this_MILISECOND_10= RULE_MILISECOND ( (lv_milis_11_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_12= RULE_MICROSECOND ( (lv_micros_13_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_14= RULE_NANOSECOND ( (lv_nanos_15_0= RULE_DECIMAL ) ) )? )
            // InternalReflex.g:2527:3: (otherlv_0= '0t' | otherlv_1= '0T' ) (this_DAY_2= RULE_DAY ( (lv_days_3_0= RULE_DECIMAL ) ) )? (this_HOUR_4= RULE_HOUR ( (lv_hours_5_0= RULE_DECIMAL ) ) )? (this_MINUTE_6= RULE_MINUTE ( (lv_minutes_7_0= RULE_DECIMAL ) ) )? (this_SECOND_8= RULE_SECOND ( (lv_seconds_9_0= RULE_DECIMAL ) ) )? (this_MILISECOND_10= RULE_MILISECOND ( (lv_milis_11_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_12= RULE_MICROSECOND ( (lv_micros_13_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_14= RULE_NANOSECOND ( (lv_nanos_15_0= RULE_DECIMAL ) ) )?
            {
            // InternalReflex.g:2527:3: (otherlv_0= '0t' | otherlv_1= '0T' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==64) ) {
                alt32=1;
            }
            else if ( (LA32_0==65) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalReflex.g:2528:4: otherlv_0= '0t'
                    {
                    otherlv_0=(Token)match(input,64,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getTimeAccess().getTKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2533:4: otherlv_1= '0T'
                    {
                    otherlv_1=(Token)match(input,65,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:2538:3: (this_DAY_2= RULE_DAY ( (lv_days_3_0= RULE_DECIMAL ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_DAY) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalReflex.g:2539:4: this_DAY_2= RULE_DAY ( (lv_days_3_0= RULE_DECIMAL ) )
                    {
                    this_DAY_2=(Token)match(input,RULE_DAY,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DAY_2, grammarAccess.getTimeAccess().getDAYTerminalRuleCall_1_0());
                      			
                    }
                    // InternalReflex.g:2543:4: ( (lv_days_3_0= RULE_DECIMAL ) )
                    // InternalReflex.g:2544:5: (lv_days_3_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:2544:5: (lv_days_3_0= RULE_DECIMAL )
                    // InternalReflex.g:2545:6: lv_days_3_0= RULE_DECIMAL
                    {
                    lv_days_3_0=(Token)match(input,RULE_DECIMAL,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_days_3_0, grammarAccess.getTimeAccess().getDaysDECIMALTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"days",
                      							true,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:2562:3: (this_HOUR_4= RULE_HOUR ( (lv_hours_5_0= RULE_DECIMAL ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_HOUR) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalReflex.g:2563:4: this_HOUR_4= RULE_HOUR ( (lv_hours_5_0= RULE_DECIMAL ) )
                    {
                    this_HOUR_4=(Token)match(input,RULE_HOUR,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_HOUR_4, grammarAccess.getTimeAccess().getHOURTerminalRuleCall_2_0());
                      			
                    }
                    // InternalReflex.g:2567:4: ( (lv_hours_5_0= RULE_DECIMAL ) )
                    // InternalReflex.g:2568:5: (lv_hours_5_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:2568:5: (lv_hours_5_0= RULE_DECIMAL )
                    // InternalReflex.g:2569:6: lv_hours_5_0= RULE_DECIMAL
                    {
                    lv_hours_5_0=(Token)match(input,RULE_DECIMAL,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_hours_5_0, grammarAccess.getTimeAccess().getHoursDECIMALTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"hours",
                      							true,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:2586:3: (this_MINUTE_6= RULE_MINUTE ( (lv_minutes_7_0= RULE_DECIMAL ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_MINUTE) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalReflex.g:2587:4: this_MINUTE_6= RULE_MINUTE ( (lv_minutes_7_0= RULE_DECIMAL ) )
                    {
                    this_MINUTE_6=(Token)match(input,RULE_MINUTE,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MINUTE_6, grammarAccess.getTimeAccess().getMINUTETerminalRuleCall_3_0());
                      			
                    }
                    // InternalReflex.g:2591:4: ( (lv_minutes_7_0= RULE_DECIMAL ) )
                    // InternalReflex.g:2592:5: (lv_minutes_7_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:2592:5: (lv_minutes_7_0= RULE_DECIMAL )
                    // InternalReflex.g:2593:6: lv_minutes_7_0= RULE_DECIMAL
                    {
                    lv_minutes_7_0=(Token)match(input,RULE_DECIMAL,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_minutes_7_0, grammarAccess.getTimeAccess().getMinutesDECIMALTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"minutes",
                      							true,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:2610:3: (this_SECOND_8= RULE_SECOND ( (lv_seconds_9_0= RULE_DECIMAL ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_SECOND) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalReflex.g:2611:4: this_SECOND_8= RULE_SECOND ( (lv_seconds_9_0= RULE_DECIMAL ) )
                    {
                    this_SECOND_8=(Token)match(input,RULE_SECOND,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_SECOND_8, grammarAccess.getTimeAccess().getSECONDTerminalRuleCall_4_0());
                      			
                    }
                    // InternalReflex.g:2615:4: ( (lv_seconds_9_0= RULE_DECIMAL ) )
                    // InternalReflex.g:2616:5: (lv_seconds_9_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:2616:5: (lv_seconds_9_0= RULE_DECIMAL )
                    // InternalReflex.g:2617:6: lv_seconds_9_0= RULE_DECIMAL
                    {
                    lv_seconds_9_0=(Token)match(input,RULE_DECIMAL,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_seconds_9_0, grammarAccess.getTimeAccess().getSecondsDECIMALTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"seconds",
                      							true,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:2634:3: (this_MILISECOND_10= RULE_MILISECOND ( (lv_milis_11_0= RULE_DECIMAL ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_MILISECOND) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalReflex.g:2635:4: this_MILISECOND_10= RULE_MILISECOND ( (lv_milis_11_0= RULE_DECIMAL ) )
                    {
                    this_MILISECOND_10=(Token)match(input,RULE_MILISECOND,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MILISECOND_10, grammarAccess.getTimeAccess().getMILISECONDTerminalRuleCall_5_0());
                      			
                    }
                    // InternalReflex.g:2639:4: ( (lv_milis_11_0= RULE_DECIMAL ) )
                    // InternalReflex.g:2640:5: (lv_milis_11_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:2640:5: (lv_milis_11_0= RULE_DECIMAL )
                    // InternalReflex.g:2641:6: lv_milis_11_0= RULE_DECIMAL
                    {
                    lv_milis_11_0=(Token)match(input,RULE_DECIMAL,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_milis_11_0, grammarAccess.getTimeAccess().getMilisDECIMALTerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"milis",
                      							true,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:2658:3: (this_MICROSECOND_12= RULE_MICROSECOND ( (lv_micros_13_0= RULE_DECIMAL ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_MICROSECOND) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalReflex.g:2659:4: this_MICROSECOND_12= RULE_MICROSECOND ( (lv_micros_13_0= RULE_DECIMAL ) )
                    {
                    this_MICROSECOND_12=(Token)match(input,RULE_MICROSECOND,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MICROSECOND_12, grammarAccess.getTimeAccess().getMICROSECONDTerminalRuleCall_6_0());
                      			
                    }
                    // InternalReflex.g:2663:4: ( (lv_micros_13_0= RULE_DECIMAL ) )
                    // InternalReflex.g:2664:5: (lv_micros_13_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:2664:5: (lv_micros_13_0= RULE_DECIMAL )
                    // InternalReflex.g:2665:6: lv_micros_13_0= RULE_DECIMAL
                    {
                    lv_micros_13_0=(Token)match(input,RULE_DECIMAL,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_micros_13_0, grammarAccess.getTimeAccess().getMicrosDECIMALTerminalRuleCall_6_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"micros",
                      							true,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:2682:3: (this_NANOSECOND_14= RULE_NANOSECOND ( (lv_nanos_15_0= RULE_DECIMAL ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_NANOSECOND) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalReflex.g:2683:4: this_NANOSECOND_14= RULE_NANOSECOND ( (lv_nanos_15_0= RULE_DECIMAL ) )
                    {
                    this_NANOSECOND_14=(Token)match(input,RULE_NANOSECOND,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_NANOSECOND_14, grammarAccess.getTimeAccess().getNANOSECONDTerminalRuleCall_7_0());
                      			
                    }
                    // InternalReflex.g:2687:4: ( (lv_nanos_15_0= RULE_DECIMAL ) )
                    // InternalReflex.g:2688:5: (lv_nanos_15_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:2688:5: (lv_nanos_15_0= RULE_DECIMAL )
                    // InternalReflex.g:2689:6: lv_nanos_15_0= RULE_DECIMAL
                    {
                    lv_nanos_15_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nanos_15_0, grammarAccess.getTimeAccess().getNanosDECIMALTerminalRuleCall_7_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nanos",
                      							true,
                      							"ru.iaie.reflex.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTime"


    // $ANTLR start "ruleRegisterType"
    // InternalReflex.g:2710:1: ruleRegisterType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator ruleRegisterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:2716:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:2717:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:2717:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==66) ) {
                alt40=1;
            }
            else if ( (LA40_0==67) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalReflex.g:2718:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:2718:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:2719:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2726:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:2726:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:2727:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterType"


    // $ANTLR start "ruleCTypeSignSpec"
    // InternalReflex.g:2737:1: ruleCTypeSignSpec returns [Enumerator current=null] : ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) ;
    public final Enumerator ruleCTypeSignSpec() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:2743:2: ( ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) )
            // InternalReflex.g:2744:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            {
            // InternalReflex.g:2744:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==68) ) {
                alt41=1;
            }
            else if ( (LA41_0==69) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalReflex.g:2745:3: (enumLiteral_0= 'signed' )
                    {
                    // InternalReflex.g:2745:3: (enumLiteral_0= 'signed' )
                    // InternalReflex.g:2746:4: enumLiteral_0= 'signed'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2753:3: (enumLiteral_1= 'unsigned' )
                    {
                    // InternalReflex.g:2753:3: (enumLiteral_1= 'unsigned' )
                    // InternalReflex.g:2754:4: enumLiteral_1= 'unsigned'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCTypeSignSpec"

    // $ANTLR start synpred1_InternalReflex
    public final void synpred1_InternalReflex_fragment() throws RecognitionException {   
        // InternalReflex.g:1271:5: ( 'else' )
        // InternalReflex.g:1271:6: 'else'
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalReflex

    // Delegated rules

    public final boolean synpred1_InternalReflex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalReflex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xC000000C00001FA0L,0x000000000000003CL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xC000000C00001F80L,0x000000000000003CL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000202400003F80L,0x0000000000000030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000200400000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000008400000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x1F88C01600000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000400400000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1F88801200000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x1F88801600000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000000001C010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0010000400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x2000200000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000001F80L,0x0000000000000030L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0002008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000009000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000001C00L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000003F80002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000003F00002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000003E00002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000003C00002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000002000002L});

}