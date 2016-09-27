import unittest
import mapper
import position
import project
import team
import item
import empolyee

class deco_test(unittest.TestCase):
    def setUp(self):
        pass

    def test_get_cls_Position(self):
        keys = ['PositionId', 'Title']
        position_obj = mapper.get_cls(position.Position,\
                "Position", 1, "PositionId", keys)
        self.assertEqual(1, position_obj.PositionId)
        self.assertEqual('boss', position_obj.Title)


    def test_get_cls_Project(self):
        keys = ['ProjectId', 'Title']
        project_obj = mapper.get_cls(project.Project, \
                "Project", 1, "ProjectId", keys)
        self.assertEqual(1, project_obj.ProjectId)
        self.assertEqual('SVW', project_obj.Title)

    def test_get_cls_Team(self):
        keys = ['TeamId', 'ProjectId', 'Name']
        team_obj = mapper.get_cls(team.Team, \
                "Team", 1, "TeamId", keys)
        self.assertEqual(1, team_obj.TeamId)

    def test_get_cls_empolyee(self):
        keys = ['Name', 'En', 'TeamId', 'ProjectId', 'PositionId']
        empolyee_obj = mapper.get_cls(empolyee.Empolyee, \
                "Empolyee", 1, "En", keys)
        self.assertEqual(1, empolyee_obj.En)

if __name__ == "__main__":
    unittest.main()
